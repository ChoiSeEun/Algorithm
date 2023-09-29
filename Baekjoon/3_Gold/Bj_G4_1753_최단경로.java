import java.io.*;
import java.util.*;

public class Bj_G4_1753_최단경로 {
	
	public static class Node{
		int vertext,weight;
		Node next;
		
		public Node(int vertext,int weight,Node next) {
			this.vertext = vertext;
			this.weight = weight;
			this.next = next;
		}
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	
    	int K = Integer.parseInt(br.readLine()); // 시작 정점 
    	
    	Node[] adjList = new Node[V+1];
    	int[] distance = new int[V+1];
    	boolean[] visited = new boolean[V+1];
    	
    	// 간선 입력 받기 
    	for(int i=0;i<E;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		adjList[u] = new Node(v,w,adjList[u]);
    	}
    	
    	final int INF = Integer.MAX_VALUE;
    	Arrays.fill(distance, INF);
    	
    	distance[K] = 0;
    	int min = 0, stopOver = 0;
    	for(int i=1;i<V+1;i++) {
    		stopOver = -1;
    		min = INF;
    		// 이동할 정점 찾기 
    		for(int j=1;j<V+1;j++) {
    			if(!visited[j] && min>distance[j]) {
    				stopOver = j;
    				min = distance[j];
    			}
    		}
    		// 갈 곳이 없는 경우 종료 
    		if(stopOver==-1) break;
    		// 방문 처리 
    		visited[stopOver] = true;
    		
    		// 최소 비용 갱신
    		for(Node temp=adjList[stopOver];temp!=null;temp=temp.next) {
    			if(!visited[temp.vertext] && distance[temp.vertext]>min+temp.weight) {
    				distance[temp.vertext] = min+temp.weight;
    			}
    		}
    	}
    	// 출력
    	for(int i=1;i<V+1;i++) {
    		if(distance[i]!=INF) System.out.println(distance[i]);
    		else System.out.println("INF");
    	}
    	br.close();
    }
}