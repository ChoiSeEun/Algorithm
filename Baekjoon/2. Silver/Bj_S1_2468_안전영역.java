
import java.util.*;
import java.io.*;

public class Main_bj_s1_2468_안전영역 {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static final int[] di = {1,0,-1,0};
	static final int[] dj = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 높이 정보 입력 받기 
		map = new int[N][N];
		int max_height = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]>max_height) max_height = map[i][j];
			}
 		}
		// 안전한 영역 계산 
		int safe_cnt = 1; // 아무것도 물에 잠기지 않는 경우 1 
		for(int height=1;height<=max_height;height++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j]>height)
						cnt += bfs(i,j,height);
				}
			}
			if (cnt>safe_cnt) safe_cnt = cnt;
		}
		System.out.println(safe_cnt);
		br.close();
	}
	static int bfs(int i,int j,int height) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0;d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj] && map[ni][nj]>height) {
					visited[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
		return 1;
	}
}
