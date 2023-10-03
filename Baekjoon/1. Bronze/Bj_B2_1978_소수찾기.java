import java.io.*;
import java.util.*;

public class Bj_B2_1978_소수찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		boolean[] prime = new boolean[1001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for(int i=2;i<=max;i++) {
			if(prime[i]) {
				int j = 2;
				while(i*j<=max) {
					prime[i*j] = false;
					j++;
				}
			}
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(prime[arr[i]]) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

}
