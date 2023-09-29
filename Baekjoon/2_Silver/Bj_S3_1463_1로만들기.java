import java.io.*;
import java.util.*;
public class Bj_S3_1463_1로만들기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[]dp = new int[N+1];
        
        dp[1] = 0;
        if(N>=2)
            dp[2] = 1;
        if(N>=3)
            dp[3] = 1;
        
        for(int i=4;i<N+1;i++){
            int temp = 0;
            if(i%6==0)
                temp = Math.min(dp[i-1],Math.min(dp[i/2],dp[i/3]));
            else if(i%2==0)
                temp = Math.min(dp[i-1],dp[i/2]);
            else if(i%3==0)
                temp = Math.min(dp[i-1],dp[i/3]);
            else
                temp = dp[i-1];
            dp[i] = temp+1;
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
