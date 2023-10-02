import java.io.*;
import java.util.*;
public class Bj_S3_2606_바이러스 {
    static int[][] graph;
    static int C;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         C = Integer.parseInt(br.readLine());
         graph = new int[C+1][C+1];
         visited = new boolean[C+1];

         int N = Integer.parseInt(br.readLine());
         StringTokenizer st;
         for(int i=0;i<N;i++){
             st = new StringTokenizer(br.readLine()," ");
             int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             graph[start][end] = 1;
             graph[end][start] = 1;
         }
         System.out.println(bfs(1));
         br.close();
    }
    static int bfs(int start){
        int cnt  = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=1;i<=C;i++){
                if(graph[now][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
