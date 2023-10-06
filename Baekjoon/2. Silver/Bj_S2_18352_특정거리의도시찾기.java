import java.io.*;
import java.util.*;
public class Bj_S2_18352_특정거리의도시찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] adjList = new ArrayList[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b,1));
        }

        // dijkstra
        distance[X] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(X,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int vertex = node.cityNum;
            int cost = node.cost;
            if(distance[vertex]<cost) continue;

            for(int i=0;i<adjList[vertex].size();i++){
                int temp = adjList[vertex].get(i).cityNum;
                int tempCost = adjList[vertex].get(i).cost;
                if(distance[temp]>cost+tempCost){
                    distance[temp] = cost+tempCost;
                    queue.add(new Node(temp,cost+tempCost));
                }
            }
        }

        int cnt = 0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]==K){
                System.out.println(i);
                cnt++;
            }
        }
        if(cnt==0) System.out.println(-1);
        br.close();
    }
}
class Node implements Comparable<Node>{
    int cityNum;
    int cost;
    public Node(int cityNum,int cost){
        this.cityNum = cityNum;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
