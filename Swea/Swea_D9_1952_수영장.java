import java.io.*;
import java.util.*;

public class Swea_D9_1952_수영장 {
    static int minCost;
    static int[] cost = new int[4];
    static int[] yearPlan = new int[12];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 금액 입력
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++)
                cost[i] = Integer.parseInt(st.nextToken());
            // 1년 이용 금액으로 초기화
            minCost = cost[3];
            // 이용 계획 입력
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 12; i++)
                yearPlan[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static void dfs(int month, int nowCost, int pass) {
        if (month == 12) {
            minCost = Math.min(nowCost, minCost);
            return;
        }
        // 이 전에 3달 이용권으로 사용한 경우
        if (pass > 0)
            dfs(month + 1, nowCost, pass - 1);
        dfs(month + 1, nowCost + cost[0] * yearPlan[month], 0); // 1일 이용권
        dfs(month + 1, nowCost + cost[1], 0); // 1달 이용권
        dfs(month + 1, nowCost + cost[2], 2); // 3달 이용권
        return;
    }
}
