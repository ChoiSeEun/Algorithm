import java.io.*;
import java.util.*;
public class SWEA_D4_7465_창용마을무리의개수 {
	
	static int N;
	static int[][] town;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N= Integer.parseInt(st.nextToken());
			town = new int[N][N];
			visited = new boolean[N];
			
			int M = Integer.parseInt(st.nextToken());
			int groupCnt = 0;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				town[a][b] = town[b][a] = 1;
			}
			
			for(int i=0;i<N;i++) {
				if(!visited[i]) {
					groupCnt++;
					bfs(i);
				}
			}
			sb.append("#").append(tc).append(" ").append(groupCnt).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static void bfs(int v) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int V = queue.poll();
			
			for(int i=0;i<N;i++) {
				if(town[V][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
