import java.util.*;
import java.io.*;

public class Bj_B2_2798_블랙잭 {

	static int N,M,nearSum;
	static int[] cards,selected = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)
			cards[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(cards);
		combination(0,0);
		System.out.println(nearSum);
		br.close();
		
	}
	static void combination(int cnt,int start) {
		if (cnt==3) {
			int sum = 0;
			for(int i=0;i<3;i++)
				sum += selected[i];
			if(sum<=M & Math.abs(sum-M)<Math.abs(nearSum-M))
				nearSum = sum;
			return;
		}
		for(int i=start;i<N;i++) {
			selected[cnt] = cards[i];
			combination(cnt+1,i+1);
		}
	}
}
