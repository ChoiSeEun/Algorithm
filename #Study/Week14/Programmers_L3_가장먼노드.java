
import java.util.*;

public class Programmers_L3_가장먼노드 {

	static ArrayList<Integer>[] graph;
	
	public int solution(int n,int[][] edge) {
		graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<edge.length;i++) {
			graph[edge[i][0]].add(edge[i][1]);
			graph[edge[i][1]].add(edge[i][0]);
		}
		
		int answer = bfs(1,n);
		return answer;
	}
	
	static int bfs(int start, int n) {
		boolean[] visited = new boolean[n+1];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {start,0});
		visited[start] = true;
		
		int maxDepth = 0;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int now = poll[0];
			int depth = poll[1];
			
			if(depth==maxDepth) cnt++;
			else if(depth>maxDepth) {
				maxDepth = depth;
				cnt=1;
			}
			
			for(int i=0;i<graph[now].size();i++) {
				int v = graph[now].get(i);
				if(visited[v]) continue;
				
				queue.offer(new int[] {v,depth+1});
				visited[v] = true;
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws Exception{
	}

}
