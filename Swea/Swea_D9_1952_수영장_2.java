import java.io.*;
import java.util.*;

public class Swea_D9_1952_수영장_2 {

    static int minCost;
    static int[] cost = new int[4];
    static int[] yearPlan = new int[13];

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
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= 12; i++) {
                int days = Integer.parseInt(st.nextToken());
                yearPlan[i] = Math.min(yearPlan[i - 1] + days * cost[0], yearPlan[i - 1] + cost[1]);
                if (i >= 3)
                    yearPlan[i] = Math.min(yearPlan[i], yearPlan[i - 3] + cost[2]);
            }
            minCost = Math.min(minCost, yearPlan[12]);
            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
