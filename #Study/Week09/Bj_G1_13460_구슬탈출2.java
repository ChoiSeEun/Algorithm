package ssafy.study.Week09;

import java.io.*;
import java.util.*;

public class Bj_G1_13460_구슬탈출2 {
	
	static int N,M;
	static char[][]board;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class Marble{
		int redX,redY;
		int blueX,blueY;
		int cnt;
		public Marble(int redX,int redY,int blueX,int blueY,int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
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
					marble.redX = i;
					marble.redY = j;
					board[i][j] = '.';
				}
				if(board[i][j]=='B') {
					marble.blueX = i;
					marble.blueY = j;
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
			
			for(int d=0;d<4;d++){
				int redX = m.redX;
				int redY = m.redY;
				int blueX = m.blueX;
				int blueY = m.blueY;
				
				boolean RedHole = false;
				boolean BlueHole = false;
				
				
				// 빨간공 이동 
				while(true) {
					int nredX = redX + di[d];
					int nredY = redY + dj[d];
					if(board[nredX][nredY]=='#') {
						break;
					}
					if(board[nredX][nredY]=='O') {
						RedHole = true;
						break;
					}
					redX = nredX;
					redY = nredY;
			
				}
			
				// 파란공 이동 
				while(true) {
					int nblueX = blueX + di[d];
					int nblueY = blueY + dj[d];
					if(board[nblueX][nblueY]=='#') {
						break;
					}
					if(board[nblueX][nblueY]=='O') {
						BlueHole = true;
						break;
					}
					blueX = nblueX;
					blueY = nblueY;
			
				}
				
				// 파란공이 들어간 경우 실패 
				if(BlueHole) continue;
				// 빨간공만 들어간 경우 성공 
				else if(RedHole) return m.cnt+1;
				
				// 구슬이 겹치는 경우
				if(redX==blueX && redY==blueY) {
					// 위쪽으로 움직인 경우 
					if(d==0) {
						if(m.redX<m.blueX) blueX++;
						else redX++;
					}
					// 아래쪽으로 움직인 경우 
					else if(d==1) {
						if(m.redX<m.blueX) redX--;
						else blueX--;
					// 왼쪽으로 움직인 경우 
					}else if(d==2) {
						if(m.redY<m.blueY) blueY++;
						else redY++;
					// 아래쪽으로 움직인 경우 
					}else {
						if(m.redY<m.blueY) redY--;
						else blueY--;
					}
				}
				queue.offer(new Marble(redX,redY,blueX,blueY,m.cnt+1));
			}
		}
		return -1;
	}
}
