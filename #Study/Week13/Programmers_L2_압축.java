import java.util.*;
class Programmers_L2_압축 {
    public int[] solution(String msg) {
        List<Integer> compress = new ArrayList<>();
        HashMap<String,Integer> dic = new HashMap<>();
        boolean[] checked = new boolean[msg.length()];
        int num = 26;
        for(int i=1;i<= num;i++){
            dic.put(Character.toString('A'+ i-1), i);
        }
        for(int i=0;i<msg.length();i++){
            if(checked[i]) continue;
            int j = 1;
            while(true){
                if(i+j>msg.length()) break;
                if(!(dic.containsKey(msg.substring(i,i+j)))) break;
        
                checked[i+j-1] = true;
                j++;
                
            }
            if(i+j>msg.length()){
                compress.add(dic.get(msg.substring(i)));
                continue;
            }
            compress.add(dic.get(msg.substring(i,i+j-1)));
            dic.put(msg.substring(i,i+j),++num);
        }
        
        
        int[] answer = new int[compress.size()];
        for(int i=0;i<compress.size();i++){
            answer[i] = compress.get(i);
        }
        return answer;
    }
}
