import java.io.*;
import java.util.*;

public class Bj_G4_17069_파이프옮기기2 {

	static int[][] house;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];
		
		StringTokenizer st;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) 
				house[i][j] = Integer.parseInt(st.nextToken());
			
		}
		
		dp[1][2][0] = 1;
		
		for(int i=1;i<=N;i++) {
			for(int j=3;j<=N;j++) {
				if(house[i][j]==1) continue;
				
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				if(i==1) continue;
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				if(house[i-1][j]==1 || house[i][j-1]==1) continue;
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
		br.close();
	}
}
