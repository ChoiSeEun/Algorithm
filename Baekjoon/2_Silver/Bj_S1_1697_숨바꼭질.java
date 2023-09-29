import java.io.*;
import java.util.*;
public class Bj_S1_1697_숨바꼭질 {
    static int[] visited = new int[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);
        System.out.println(visited[K]);
        br.close();
    }
    static void bfs(int N,int K){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now==K){
                visited[K] = visited[now]-1;
                break;
            }
            int next;
            for(int i=0;i<3;i++){
                if(i==0) next = now-1;
                else if(i==1) next = now+1;
                else next = now*2;
                if(0<=next && next<visited.length && visited[next]==0){
                    queue.offer(next);
                    visited[next] = visited[now]+1;
                }
            }
        }
    }
}
