import java.io.*;
import java.util.*;
public class Bj_G3_2252_줄세우기 {
    static int N,M;
    static List<Integer>[]graph;
    static int[] indegree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        indegree = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indegree[B]++;
        }
        topologySort();
        br.close();
    }
    static void topologySort(){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int i = queue.poll();
            System.out.print(i+" ");
            for(int j:graph[i]){
                indegree[j]--;
                if(indegree[j]==0) queue.offer(j);
            }
        }
    }
}
