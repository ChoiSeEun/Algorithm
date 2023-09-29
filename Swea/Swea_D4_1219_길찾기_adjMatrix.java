import java.io.*;
import java.util.*;
public class Swea_D4_1219_길찾기_adjMatrix {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("Lecture\\res\\input_d4_1219.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=10;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int testcase = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            
            int[][] adjMatrix = new int[100][100];
            boolean[] visited = new boolean[100];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<edge;i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjMatrix[start][end] = 1;
            }
            // dfs(0,adjMatrix,visited);
            // int answer = visited[99]?1:0;
            int answer = bfs(adjMatrix,visited);
            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void dfs(int i,int[][] adjMatrix,boolean[] visited){
        visited[i] = true;
        
        for(int j=0;j<100;j++){
            if(adjMatrix[i][j]==1 && !visited[j])
                dfs(j,adjMatrix,visited);
        }
    }
    static int bfs(int[][] adjMatrix,boolean[] visited){
        ArrayDeque<Integer> queue  = new ArrayDeque<>();
        // 시작 정점 추가 
        queue.offer(0);
        visited[0] = true; 

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<100;i++){
                if(adjMatrix[now][i]==1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        if(visited[99]) return 1;
        return 0;
    }
}