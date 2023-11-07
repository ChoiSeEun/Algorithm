import java.util.*;

public class Programmers_L2_주차요금계산 {
	public static void main(String[] args) {
		
	}
	static class Solution {
	    public int[] solution(int[] fees, String[] records) {
	        Map<String,Integer> map = new HashMap<>(); // 출차 여부
	        Map<String,Integer> cost = new TreeMap<>(); // 출차 시간 기록
	        List<Integer> answer = new ArrayList<>(); // 최종 답안 
	        
	        StringTokenizer st;
	        for(String r :records){
	            st = new StringTokenizer(r);
	            String time = st.nextToken();
	            String car = st.nextToken();
	            String flag = st.nextToken();
	            
	            // 입차 
	            if(flag.equals("IN")){
	                map.put(car,convertTime(time));
	                continue;
	            }
	            // 출차 
	            int diff = convertTime(time)-map.get(car);
	            // 1. 새로 들어온 차량
	            if(!cost.containsKey(car)){
	                cost.put(car,diff);
	            }
	            // 2. 이미 들어왔던 차량 
	            else{
	                cost.put(car,cost.get(car)+diff);
	            }
	            map.remove(car); 
	        }
	        // 아직 출차하지 않은 차 
	        if(!map.isEmpty()){
	            for(String car:map.keySet()){
	                Integer c = cost.get(car);
	                c = (c==null)?0:c;
	                cost.put(car,c+(23*60+59)-map.get(car));
	            }    
	        }
	        
	        for(Integer c:cost.values()){
	            if(c<=fees[0]){
	                answer.add(fees[1]);
	            }else{
	                answer.add((int)(fees[1] + Math.ceil((double) (c - fees[0]) / fees[2]) * fees[3]));
	            }
	        }
	        return answer.stream().mapToInt(Integer::intValue).toArray();
	        
	    }
	    static int convertTime(String time){
	        StringTokenizer st = new StringTokenizer(time,":");
	        int hour = Integer.parseInt(st.nextToken());
	        int minute = Integer.parseInt(st.nextToken());
	        return hour*60+minute;
	    }
	}
}
