import java.io.*;
import java.util.*;

public class Bj_S2_1260_DFS와BFS {
    static int N,M;
    static int[][]adjMatrix;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjMatrix = new int[N+1][N+1];
        

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjMatrix[A][B] = 1;
            adjMatrix[B][A] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
        br.close();
    }   
    static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");
        for(int i=1;i<=N;i++){
            if(adjMatrix[v][i]==1 && !visited[i])
                dfs(i);
        }
    }
    static void bfs(int v){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visited[v] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int i=1;i<=N;i++){
                if(adjMatrix[now][i]==1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}