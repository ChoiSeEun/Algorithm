import java.io.*;
import java.util.*;
public class Bj_S3_11726_2n타일링 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N>=2)
            dp[2] = 2;

        for(int i=3;i<N+1;i++){
            dp[i] = (dp[i-2]+dp[i-1])%10007;
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
