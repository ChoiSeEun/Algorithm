import java.io.*;
import java.util.*;
public class Bj_S1_1149_rgb거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int[][]cost = new int[N][3];
        int[][]dp = new int[N][3];
        // 입력받기 
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }
        // 1번째 집은 비용의 최소값 저장 
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        // 바로 앞의 집과 다른 색깔 중에 최소값 + 자신의 값이 최소 비용 
        for(int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + cost[i][2];
        }

        int min = Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2]));
        System.out.println(min);
        br.close();
    }
}
