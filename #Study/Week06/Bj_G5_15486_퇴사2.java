package ssafy.study.Week06;

import java.io.*;
import java.util.*;

public class Bj_G5_15486_퇴사2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] counsel = new int[N + 2][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            counsel[i][0] = Integer.parseInt(st.nextToken()); // 상담에 걸리는 시간
            counsel[i][1] = Integer.parseInt(st.nextToken()); // 상담 수익
        }
        // dp[i] : i일에 받을 수 있는 최대 수익
        int[] dp = new int[N + 2];
        int max = 0;
        for (int i = 1; i < N + 2; i++) {
            max = Math.max(max, dp[i]);

            int end = i + counsel[i][0]; // 해당 상담을 해서 돈을 받을 수 있는 날짜
            if (end <= N + 1)
                dp[end] = Math.max(dp[end], max + counsel[i][1]);
        }
        System.out.println(max);
        br.close();
    }
}

