import java.io.*;
import java.util.*;
public class Swea_D4_3124_최소스패닝트리 {
    
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;
        public Edge(int from,int to,int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge o){
            return Integer.compare(this.weight,o.weight);
        }
    }
    static Edge[] edgeList;
    static int V,E;
    static int[] parents;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edgeList = new Edge[E];
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine(), " "); 
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(A, B, C); 
            }
            Arrays.sort(edgeList);
            make();
            long answer = 0;
            int count = 0;
            for(Edge edge:edgeList){
                if(union(edge.from,edge.to)){
                    answer += edge.weight;
                    if(++count==V-1) break;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    static void make(){
        parents = new int[V+1];
        for(int i=1;i<=V;i++)
            parents[i] = i;
    }

    static int find(int a){
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
