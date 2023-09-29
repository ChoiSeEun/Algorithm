import java.io.*;
import java.util.*;

public class Swea_D4_7733_치즈도둑{

	static int N; // 치즈 한 변의 길이 
	static int[][] cheese; // 치즈 배열
	static boolean[][] visited; // 방문 여부 배열 
	// 상우하좌
	static final int[] di = {-1,0,1,0}; 
	static final int[] dj = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			// 치즈 입력 받기 
			cheese = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					cheese[i][j] = Integer.parseInt(st.nextToken());
			}
			int max_cnt = Integer.MIN_VALUE; // 가장 많은 치즈 덩어리 
			for(int day=0;day<=100;day++) {
				visited = new boolean[N][N];
				int cnt = bfs(day);
				if (cnt>max_cnt) max_cnt = cnt;
			}
			
			sb.append("#").append(tc).append(" ").append(max_cnt).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static int bfs(int day) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt=0;
		// 치즈 전체 탐색 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				// 먹히지 않았고, 방문하지 않은 지점만 탐색 
				if(cheese[i][j]>day && !visited[i][j]) {
					visited[i][j] = true;
					q.offer(new int[] {i,j});
					// queue가 비었다는 의미는 덩어리 탐색이 끝났다는 의미
					while(!q.isEmpty()) {
						int[] ij = q.poll();
						int ni = ij[0];
						int nj = ij[1];
					
						for(int d=0;d<4;d++) {
							int mi = ni +di[d];
							int mj = nj +dj[d];
							// 범위를 벗어나지 않으며, 먹히지 않은 부분만 탐색 
							if(0<=mi&&mi<N && 0<=mj&&mj<N && !visited[mi][mj] && cheese[mi][mj]>day) {
								visited[mi][mj] = true;
								q.offer(new int[] {mi,mj});
							}
						}
					}
					cnt ++;
				}
				
			}
		}
		return cnt;
	}
}
