import java.io.*;
import java.util.*;

public class Bj_G5_13023_ABCDE {
    static List<Integer>[] adjList;
    // static int[][] adjMatrix;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new List[N];
        for(int i=0;i<N;i++) adjList[i] = new ArrayList<>();
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        int res = 0;
        for(int i=0;i<N;i++){
            res = dfs(i,1,new boolean[N]);
            if(res==1) break;
        }
        System.out.println(res);
        br.close();
    }
    static int dfs(int i,int count,boolean[] visited){
        visited[i] = true;
        if(count==5)
            return 1;

        for(int j:adjList[i]){
            if(!visited[j]){
                int res = dfs(j,count+1,visited);
                if(res==1) return 1;
            }
        }
        visited[i] = false;
        return 0;
    }
}
