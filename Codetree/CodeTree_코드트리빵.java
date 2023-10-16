import java.io.*;
import java.util.*;

public class CodeTree_코드트리빵 {
	
	static int N,M;
	static int[][] map;
	static Point[] convenience;
	static Point[] people;
	static int Time;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean[][] visited;
	static int[][] dist;
	static Point notMap = new Point(-1,-1);
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		convenience = new Point[M+1];
		people = new Point[M+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			convenience[i] = new Point(x,y);
			people[i] = notMap;
		}
		Time = 1;
		while(true) {
			movepeople();
			if(Time<=M) movebasecamp();
			if(allComplete()) break;
			Time++;
		}
		System.out.println(Time);
		br.close();
	}
	// 편의점방향으로 이동하기 
	// 모든 사람 이동 후 편의점으로 도착한 사람들 확인까지 
	static void movepeople() {
		for(int p=1;p<=M;p++) {
			// 아직 맵에 없는 사람인 경우 패스 
			if(people[p].x==-1 && people[p].y==-1) continue;
			// 편의점에 도착한 사람인 경우 패스 
			if(people[p].x==convenience[p].x && people[p].y==convenience[p].y) continue;
			
			// 편의점 방향으로 이동하기 
			bfs(convenience[p]);
			Point move = new Point(-1,-1);
			int minDist = Integer.MAX_VALUE;
			
			int x = people[p].x;
			int y = people[p].y;
			for(int d=0;d<4;d++){
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(isAvailable(nx,ny)&&visited[nx][ny] && dist[nx][ny]<minDist) {
					move.x = nx;
					move.y = ny;
					minDist = dist[nx][ny];
				}
			}
			
			people[p] = move;
//			System.out.println(Time + "초 움직이기 ");
//			System.out.println(people[p].x + " "+people[p].y);
		}
		// 이번에 새롭게 편의점에 들어가게 된 곳처리 
		for(int p=1;p<=M;p++) {
			if(people[p].x==convenience[p].x && people[p].y==convenience[p].y
					&& map[people[p].x][people[p].y]!=-2) {
				map[people[p].x][people[p].y] = -2;
			}
		}
		
	}
	// t초에 t번째 사람 베이스캠프로 들어가기 
	static void movebasecamp() {
		
		bfs(convenience[Time]);
		Point base = new Point(-1,-1);
		int minDist = Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(visited[i][j] && dist[i][j]<minDist && map[i][j]==1) {
					base.x = i;
					base.y = j;
					minDist = dist[i][j];
				}
			}
		}
		people[Time] = base;
//		System.out.println(people[Time].x + " "+people[Time].y);
		map[base.x][base.y] = -2;
	}
	
	// 특정 지점기준 인접한 곳의 최단 거리를 계산 
	static void bfs(Point point) {
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				visited[i][j] = false;
				dist[i][j] = 0;
			}
		}
		
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.offer(point);
		visited[point.x][point.y] = true;
		
		while(!queue.isEmpty()) {
			Point poll = queue.poll();
			int x = poll.x;
			int y = poll.y;
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(isAvailable(nx,ny) && !visited[nx][ny] && map[nx][ny]!=-2) {
					queue.offer(new Point(nx,ny));
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y]+1;
				}
			}
		}
		
	}
	static boolean isAvailable(int x,int y) {
		if(1<=x && x<=N && 1<=y && y<=N) return true;
		return false;
	}
	
	// 모든 사람이 편의점에 도착했는지 확인 
	// 한 사람이라도 편의점에 위치하지 않으면 false 리턴 
	static boolean allComplete() {
		for(int p=1;p<=M;p++) {
			if(!(people[p].x==convenience[p].x &&
					people[p].y==convenience[p].y))
				return false;
		}
		return true;
	}
	
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}