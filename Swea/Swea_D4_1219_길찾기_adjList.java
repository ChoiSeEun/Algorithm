import java.io.*;
import java.util.*;
public class Swea_D4_1219_길찾기_adjList {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("Lecture\\res\\input_d4_1219.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer>[] adjList = new List[100];

        for(int tc=1;tc<=10;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int testcase = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            
            for(int i=0;i<100;i++) adjList[i] = new ArrayList<Integer>();

            boolean[] visited = new boolean[100];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<edge;i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList[start].add(end);
            }
            // dfs(0,adjList,visited);
            // int answer = visited[99]?1:0;
            int answer = bfs(adjList,visited);
            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void dfs(int i,List<Integer>[] adjList,boolean[] visited){
        visited[i] = true;

        for(int j:adjList[i]){
            if(!visited[j])
                dfs(j,adjList,visited);
        }
        
    }
    static int bfs(List<Integer>[] adjList,boolean[] visited){
        ArrayDeque<Integer> queue  = new ArrayDeque<>();
        // 시작 정점 추가 
        queue.offer(0);
        visited[0] = true; 

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int j:adjList[now]){
                if(!visited[j]){
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
        if(visited[99]) return 1;
        return 0;
    }
}