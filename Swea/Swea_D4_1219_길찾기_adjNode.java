import java.io.*;
import java.util.*;
public class Swea_D4_1219_길찾기_adjNode {

    static class Node{
        int vertex;
        Node next;
        public Node(int vertex,Node next){
            this.vertex = vertex;
            this.next = next;
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("Lecture\\res\\input_d4_1219.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=10;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int testcase = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            
            Node[] adjList = new Node[100];

            boolean[] visited = new boolean[100];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<edge;i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList[start] = new Node(end,adjList[start]);
            }
            // dfs(0,adjList,visited);
            // int answer = visited[99]?1:0;
            int answer = bfs(adjList,visited);
            sb.append("#").append(testcase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void dfs(int i,Node[] adjList,boolean[] visited){
        visited[i] = true;

        for(Node j=adjList[i];j!=null;j=j.next){
            if(!visited[j.vertex]){
                visited[j.vertex] = true;
                dfs(j.vertex,adjList,visited);
            }
        }

    }
    static int bfs(Node[] adjList,boolean[] visited){
        ArrayDeque<Integer> queue  = new ArrayDeque<>();
        // 시작 정점 추가 
        queue.offer(0);
        visited[0] = true; 

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Node j=adjList[now];j!=null;j=j.next){
                if(!visited[j.vertex]){
                    queue.offer(j.vertex);
                    visited[j.vertex] = true;
                }
            }
        }
        if(visited[99]) return 1;
        return 0;
    }
}