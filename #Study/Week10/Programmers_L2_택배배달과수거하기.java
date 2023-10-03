import java.util.*;
public class Programmers_L2_택배배달과수거하기 {
	
	public static void main(String[] args) throws Exception{
		int cap = 2;
		int n = 7;
		int[] deliveries ={1,0,2,0,1,0,2};
		int[] pickups = {0,2,0,1,0,2,0};
		
		System.out.println(solution(cap,n,deliveries,pickups));
	}
	public static long solution(int cap,int n,int[] deliveries,int[] pickups) {
		long answer = 0;
		ArrayDeque<House> deliverStack = new ArrayDeque<>();
		ArrayDeque<House> pickupStack = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			if(deliveries[i]!=0) deliverStack.offerLast(new House(deliveries[i],i+1));
			if(pickups[i]!=0) pickupStack.offerLast(new House(pickups[i],i+1));
		}
		
		while(!deliverStack.isEmpty() || !pickupStack.isEmpty()) {
			int sum = 0;
			int dist = 0;
			while(!deliverStack.isEmpty() && sum<cap) {
				House house = deliverStack.pollLast();
				dist = Math.max(dist, house.dist);
				
				if(house.box+sum<=cap) sum += house.box;
				else {
					house.box -= (cap-sum);
					deliverStack.offerLast(house);
					break;
				}
			}
			sum = 0;
			while(!pickupStack.isEmpty() && sum < cap) {
				House house = pickupStack.pollLast();
				dist = Math.max(dist, house.dist);
				
				if(house.box+sum<=cap) sum += house.box;
				else {
					house.box -= (cap-sum);
					pickupStack.offerLast(house);
					break;
				}
			}
			answer += dist*2;
			
		}
		
		return answer;
	}
	static class House{
		int box;
		int dist;
		public House(int box,int dist) {
			this.box = box;
			this.dist = dist;
		}
	}
}
