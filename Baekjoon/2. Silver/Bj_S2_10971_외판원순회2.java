import java.io.*;
import java.util.*;

public class Bj_S2_10971_외판원순회2 {

    static int N;
    static int[][] city;
    static long minCost = Long.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        city = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                city[i][j] = Integer.parseInt(st.nextToken());
        }
        visited[0] = true; // 시작 노드 방문 처리
        dfs(0, 1, 0);
        System.out.println(minCost);
        br.close();
    }

    private static void dfs(int now, int depth, int cost) {
        if (depth == N) {
            if (city[now][0] != 0) { // 시작 노드로 다시 되돌아가기
                minCost = Math.min(minCost, cost + city[now][0]);
            }
            return;
        }
        for (int i = 1; i < N; i++) {
            if (!visited[i] && city[now][i] != 0) {
                visited[i] = true;
                dfs(i, depth + 1, cost + city[now][i]);
                visited[i] = false;
            }
        }
    }
}
