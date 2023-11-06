
import java.io.*;
import java.util.*;

public class Bj_G1_1194_달이차오른다가자 {

	static int N,M;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		int[] start = new int[2];
		for(int i=0;i<N;i++) {
			String row = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j]=='0') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		int result = bfs(start);
		System.out.println(result);
		br.close();
	}
	static int bfs(int[] start) {
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
	
		ArrayDeque<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][64];
		queue.offer(new Point(start[0],start[1],0,0));
		visited[start[0]][start[1]][0] = true;
		
		while(!queue.isEmpty()) {
			Point poll = queue.poll();
//			System.out.println(poll.toString());
//			System.out.println(visited[0][1][32]);
			for(int d=0;d<4;d++) {
				int nx = poll.x + dx[d];
				int ny = poll.y + dy[d];
				
				// 범위 벗어나는지 체크
				if(!isAvailable(nx,ny)) continue;

				// 출구 도착
				if(map[nx][ny]=='1') return poll.depth+1;
				
				// 방문한 경우 pass
				if(visited[nx][ny][poll.key]) continue;
				
				// 벽인 경우도 pass
				if(map[nx][ny]=='#') continue;
				
				// 빈 칸인 경우 
				if(map[nx][ny]=='.'||map[nx][ny]=='0') {
					queue.offer(new Point(nx,ny,poll.key,poll.depth+1));
					visited[nx][ny][poll.key] = true;
				}
				// 열쇠를 얻은 경우 
				if('a'<=map[nx][ny] && map[nx][ny]<='f') { // 열쇠
					int updateKey = poll.key | (1<<map[nx][ny]-'a'); // 얻은 열쇠 업데이트
					queue.offer(new Point(nx,ny,updateKey,poll.depth+1));
					visited[nx][ny][updateKey] = true;
//					System.out.println("key accepted = "+map[nx][ny]);
				}
				// 벽을 만난 경우 
				if('A'<=map[nx][ny] && map[nx][ny]<='F') { // 벽
					boolean keyHold = ((poll.key & 1<<(map[nx][ny]-'A')))!=0; // 해당하는 열쇠가 있는지 판단 
					if(keyHold) { // 열쇠가 있는 경우에만 이동
						queue.offer(new Point(nx,ny,poll.key,poll.depth+1));
						visited[nx][ny][poll.key] = true;
					}
				}
			}
		}
		return -1;
	}
	static boolean isAvailable(int x,int y) {
		if(0<=x && x<N && 0<=y && y<M) return true;
		return false;
	}
	static class Point{
		int x,y;
		int key;
		int depth;
		public Point(int x,int y,int key,int depth) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", key=" + key + ", depth=" + depth + "]";
		}
		
	}
}
