
import java.io.*;
import java.util.*;

public class Bj_G1_15644_구슬탈출3 {

	static int N,M;
	static char[][] board;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static String totalDirection;
	
	
	static class Marble{
		int rx,ry;
		int bx,by;
		int cnt;
		String direction;
		
		public Marble(int rx,int ry,int bx,int by,int cnt,String direction) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
			this.direction = direction;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		Marble marble = new Marble(0,0,0,0,0,"");
		for(int i=0;i<N;i++) {
			String row = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = row.charAt(j);
				if(board[i][j]=='R') {
					marble.rx = i;
					marble.ry = j;
					board[i][j] = '.';
				}
				if(board[i][j]=='B') {
					marble.bx = i;
					marble.by = j;
					board[i][j] = '.';
				}
			}
		}
		int answer = bfs(marble);
		if(answer!=-1) {
			System.out.println(answer);
			System.out.println(totalDirection);
		}
		else {
			System.out.println(answer);
		}
		br.close();
	}
	static int bfs(Marble marble) {
		ArrayDeque<Marble> queue = new ArrayDeque<>();
		queue.offer(marble);
		
		while(!queue.isEmpty()) {
			Marble m = queue.poll();
			if(m.cnt>10) continue;
			
			for(int d=0;d<4;d++) {
				int rx = m.rx;
				int ry = m.ry;
				int bx = m.bx;
				int by = m.by;
				
				boolean redHole = false;
				boolean blueHole = false;
				
				int redMove = 0;
				int blueMove = 0;
				
				// 빨간공
				while(true) {
					int nrx = rx + di[d];
					int nry = ry + dj[d];
					if(board[nrx][nry]=='#') {
						break;
					}
					if(board[nrx][nry]=='O') {
						redHole = true;
						break;
					}
					redMove++;
					rx = nrx;
					ry = nry;
				}
				// 파란공
				while(true) {
					int nbx = bx + di[d];
					int nby = by + dj[d];
					if(board[nbx][nby]=='#') {
						break;
					}
					if(board[nbx][nby]=='O') {
						blueHole = true;
						break;
					}
					blueMove++;
					bx = nbx;
					by = nby;
				}
				if(blueHole) continue;
				else if(redHole) {
					totalDirection = m.direction + dirChar(d);
					return m.cnt+1;
				}
				// 공이 겹치는 경우 
				if(rx==bx && ry==by) {
					if(redMove>blueMove) {
						rx -= di[d];
						ry -= dj[d];
					}
					else {
						bx -= di[d];
						by -= dj[d];
					}
				}
				queue.offer(new Marble(rx,ry,bx,by,m.cnt+1,m.direction + dirChar(d)));
			}
		}
		return -1;
	}
	
	static String dirChar(int d) {
		if(d==0) return "U";
		else if(d==1) return "D";
		else if(d==2) return "L";
		else return "R";
	}
}
