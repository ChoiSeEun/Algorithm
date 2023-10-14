
import java.io.*;
import java.util.*;

public class Bj_G4_15683_감시 {

	static int N,M;
	static int[][] map,origin;
	static int minCnt = Integer.MAX_VALUE; // 최소 사각지대 개수 
	static int[] cctvList;
	static int size;
	static List<CCTV> cctvPoint = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		origin = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if(origin[i][j]!=0 && origin[i][j]!=6) {
					cctvPoint.add(new CCTV(i,j,origin[i][j]));
				}
			}
		}
		size = cctvPoint.size();
		cctvList = new int[size];
		permutation(0);
		System.out.println(minCnt);
		br.close();
	}
	static void permutation(int depth) {
		if(depth==size) {
			init();
			go();
			findCnt();
			return;
		}
		for(int i=0;i<4;i++) {
			cctvList[depth] = i;
			permutation(depth+1);
		}
	}
	// 맵 초기화 
	static void init() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = origin[i][j];
			}
		}
	}
	// 정해진 방향에 따라 cctv가 감시할 수 있는 곳 찾기 
	static void go() {
		
		for(int c=0;c<size;c++) {
			CCTV now = cctvPoint.get(c);
			int d = cctvList[c];
			
			switch(now.num) {
			case 1:
				if(d==0) {
					bfs(now.x,now.y,3);
				}
				else if(d==1) {
					bfs(now.x,now.y,1);
				}
				else if(d==2) {
					bfs(now.x,now.y,2);
				}
				else {
					bfs(now.x,now.y,0);
				}
				break;
			case 2:
				if(d==0 || d==2) {
					bfs(now.x,now.y,2);
					bfs(now.x,now.y,3);
				}
				else {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,1);
				}
				break;
			case 3:
				if(d==0) {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,3);
				}
				else if(d==1) {
					bfs(now.x,now.y,1);
					bfs(now.x,now.y,3);
				}
				else if(d==2) {
					bfs(now.x,now.y,2);
					bfs(now.x,now.y,1);
				}
				else {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,2);
				}
				break;
			case 4:
				if(d==0) {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,2);
					bfs(now.x,now.y,3);
				}
				else if(d==1) {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,1);
					bfs(now.x,now.y,3);
				}
				else if(d==2) {
					bfs(now.x,now.y,2);
					bfs(now.x,now.y,3);
					bfs(now.x,now.y,1);
				}
				else {
					bfs(now.x,now.y,0);
					bfs(now.x,now.y,1);
					bfs(now.x,now.y,2);
				}
				break;
			case 5:
				bfs(now.x,now.y,0);
				bfs(now.x,now.y,1);
				bfs(now.x,now.y,2);
				bfs(now.x,now.y,3);
				break;
			}
		}
//		for(int[]m:map) System.out.println(Arrays.toString(m));
	}
	static void bfs(int x,int y,int d) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			x = poll[0];
			y = poll[1];
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!isAvailable(nx,ny) || map[nx][ny]==6) break;
			if(map[nx][ny]==0) map[nx][ny] = -1;
			queue.offer(new int[] {nx,ny});
			
		}
	}
	static boolean isAvailable(int x,int y) {
		if(0<=x && x<N && 0<=y && y<M) return true;
		return false;
	}
	// 사각지대 개수 찾기 
	static void findCnt() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		minCnt = Math.min(minCnt, cnt);
		return;
	}
	
	static class CCTV{
		int x,y,num;
		public CCTV(int x,int y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
