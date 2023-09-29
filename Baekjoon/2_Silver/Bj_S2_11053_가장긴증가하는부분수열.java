import java.io.*;
import java.util.*;

public class Bj_S2_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i=0;i<N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(array[i]>array[j] && dp[i]<dp[j]+1)
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int max = 0 ;
		for(int i=0;i<N;i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		br.close();
	}
}
