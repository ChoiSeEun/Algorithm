import java.util.*;
import java.io.*;

public class Bj_S2_2644_촌수계산 {

	static int N;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken())-1;
		int target = Integer.parseInt(st.nextToken())-1;
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		int result = bfs(start,target);
		System.out.println(result);
		br.close();
	}
	static int bfs(int start,int target) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		queue.offer(new int[] {start,0});
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowVertex = now[0];
			int nowDepth = now[1];
			
			if(nowVertex==target) return nowDepth;
			
			for(int v=0;v<N;v++) {
				if(graph[nowVertex][v]==1 && !visited[v]) {
					queue.offer(new int[] {v,nowDepth+1});
					visited[v] = true;
				}
			}
		}
		return -1;
	}
}
