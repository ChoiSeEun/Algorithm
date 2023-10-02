
import java.io.*;
import java.util.*;

public class Bj_G1_13459_구슬탈출 {

	static int N,M;
	static char[][] board;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class Marble{
		int rx,ry;
		int bx,by;
		int cnt;
		public Marble(int rx,int ry,int bx,int by,int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		
		Marble marble = new Marble(0,0,0,0,0);
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
		System.out.println(bfs(marble));
		br.close();
	}
	static int bfs(Marble marble) {
		ArrayDeque<Marble> queue = new ArrayDeque<>();
		queue.offer(marble);
		
		while(!queue.isEmpty()) {
			Marble m = queue.poll();
			
			if(m.cnt==10) continue;
		
			for(int d=0;d<4;d++) {
				int rx = m.rx;
				int ry = m.ry;
				int bx = m.bx;
				int by = m.by;
				
				boolean redHole = false;
				boolean blueHole = false;
				// 빨간 구슬 
				while(true) {
					int nrx = rx + di[d];
					int nry = ry + dj[d];
					if(board[nrx][nry]=='#') 
						break;
					if(board[nrx][nry]=='O') {
						redHole = true;
						break;
					}
					rx = nrx;
					ry = nry;
				}
				
				// 파란 구슬
				while(true) {
					int nbx = bx + di[d];
					int nby = by + dj[d];
					if(board[nbx][nby]=='#')
						break;
					if(board[nbx][nby]=='O') {
						blueHole = true;
						break;
					}
					bx = nbx;
					by = nby;
				}
				if(blueHole) continue;
				else if(redHole) return 1;
				
				if(rx==bx && ry==by) {
					// 위쪽
					if(d==0) {
						if(m.rx<m.bx) bx ++;
						else rx++;
						
					}
					// 아래쪽 
					else if(d==1) {
						if(m.rx<m.bx) rx--;
						else bx--;
					}
					// 왼쪽 
					else if(d==2) {
						if(m.ry<m.by) by++;
						else ry++;
					}
					// 오른쪽
					else {
						if(m.ry<m.by) ry--;
						else by--;
					}
				}
				queue.offer(new Marble(rx,ry,bx,by,m.cnt+1));
			}
		}
		return 0;
	}
}
