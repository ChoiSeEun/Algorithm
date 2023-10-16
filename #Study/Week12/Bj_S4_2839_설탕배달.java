import java.io.*;
import java.util.*;
public class Bj_S4_2839_설탕배달 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		dp[1] = dp[2] = -1;
		dp[3] = 1;
		if(N>=4) dp[4] = -1;
		if(N>=5) dp[5] = 1;
		
		for(int i=6;i<=N;i++) {
			if(dp[i-3]==-1 && dp[i-5]==-1) dp[i] = -1;
			else if(dp[i-3]==-1) dp[i] = dp[i-5]+1;
			else if(dp[i-5]==-1) dp[i] = dp [i-3]+1;
			else dp[i] = Math.min(dp[i-3],dp[i-5])+1;
		}
		System.out.println(dp[N]);
		br.close();
	}
}
