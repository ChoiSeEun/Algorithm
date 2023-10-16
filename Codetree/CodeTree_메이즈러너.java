import java.io.*;
import java.util.*;
public class CodeTree_메이즈러너 {

	static int N,M;
	static int[][] map;
	static Point[] runner;
	static Point exit;
	static int moveSum = 0;
	static int exitRunner = 0;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		runner = new Point[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			runner[i] = new Point(x,y);
		}
		exit = new Point(0,0);
		st = new StringTokenizer(br.readLine()," ");
		exit.x = Integer.parseInt(st.nextToken())-1;
		exit.y = Integer.parseInt(st.nextToken())-1;
		
		for(int time=1;time<=K;time++) {
			// 모든 참가자가 미로를 탈출한 경우 종료 
			if(exitRunner==M) break;
			moveRunner(); // 참가자 움직이기 
//			PrintRunner();
			System.out.println("time: "+time);
			rotate(); // 배열 회전 
		}
		System.out.println(moveSum);
		System.out.println((exit.x+1)+" "+(exit.y+1));
		br.close();
	}
	// 참가자 움직이기 
	// 미로에 탈출한 경우 -1로 저장됨 
	static void moveRunner() {
		for(int i=0;i<M;i++) {
			// 미로 탈출한 참가자 넘어가기 
			if(runner[i].x==-1 && runner[i].y==-1) continue;
			// 현재 출구와의 거리 구하기 
			int currentDist = dist(runner[i].x,runner[i].y,exit.x,exit.y);
			for(int d=0;d<4;d++) {
				int nx = runner[i].x + dx[d];
				int ny = runner[i].y + dy[d];
				// 범위 넘어가면 패스  
				if(0>nx || nx>=N || 0>ny || ny>=M) continue;
				// 벽이라면 이동 불가 
				if(map[nx][ny]>0) continue;
				// 출구에 도착한 경우 탈출 
				if(nx==exit.x && ny==exit.y) {
					runner[i].x = -1;
					runner[i].y = -1;
					moveSum++;
					exitRunner++;
				}
				int nextDist = dist(nx,ny,exit.x,exit.y);
				// 출구와 더 가까워지는 경우에만 이동 
				if(nextDist<currentDist) {
					runner[i].x = nx;
					runner[i].y = ny;
					moveSum++;
					break;
				}
			}
		}
	}
	// 배열 회전하기 
	static void rotate() {
		// 회전할 정사각형 찾기
		int[] info = findSquare();
		System.out.println(Arrays.toString(info));
		// 배열 회전
		int startI = info[0];
		int startJ = info[1];
		int dist = info[2];
		int[][] copy = new int[N][N];
		
		for(int i=startI;i<startI+dist;i++) {
			for(int j=startJ;j<startJ+dist;j++) {
				System.out.println(map[i][j]);
				if(map[i][j]>0) map[i][j]--;
			}
		}
		
		for(int i=0;i<dist;i++) {
			for(int j=0;j<dist;j++) {
				copy[startI+j][startJ+dist-i] = map[startI+i][startJ+j];
//				int ox = i - startI;
//				int oy = j - startJ;
//				int rx = oy;
//				int ry = dist-ox;
//				copy[rx+startI][ry+startJ] = map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = copy[i][j];
			}
		}
		for(int[]m:map) System.out.println(Arrays.toString(m));
//		PrintRunner();
//		System.out.println();
		// 참가자 회전
		for(int m=0;m<M;m++) {
			if(startI<=runner[m].x && runner[m].x<=startI+dist
					&& startJ<=runner[m].y && runner[m].y<=startJ+dist) {
				int nx = startI+runner[m].y;
				int ny = startJ+dist-runner[m].x;
				runner[m].x = nx;
				runner[m].y = ny;
			}
		}
		PrintRunner();
		// 출구 회전 
		int nx = startI+exit.y;
		int ny = startJ+dist-exit.x;
		
		exit.x = nx;
		exit.y = ny;
//		System.out.println(exit.x + " "+exit.y);
	}
	static int[] findSquare() {
		for(int dist=1;dist<N-1;dist++) {
			for(int i=0;i+dist<N;i++) {
				for(int j=0;j+dist<N;j++) {
					// 범위 내에 출구가 없는 경우 패스 
					if(i>exit.x || exit.x>i+dist || j>exit.y || exit.y>j+dist) continue;
//					System.out.println(i+" "+j+" "+dist);
//					System.out.println(exit.x+" "+exit.y);
					boolean isRunner = false;
					for(int m=0;m<M;m++) {
						if(i<=runner[m].x && runner[m].x<=i+dist
								&& j<=runner[m].y && runner[m].y<=j+dist) {
							
							isRunner = true;
							break;
						}
					}
					if(isRunner)
						return new int[] {i,j,dist};
				}
			}
		}
		return new int[]{0,0,0};
	}
	static int dist(int x1,int y1,int x2,int y2){
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static void PrintRunner() {
		for(Point r:runner) System.out.println(r.x +" "+r.y);
	}
}
