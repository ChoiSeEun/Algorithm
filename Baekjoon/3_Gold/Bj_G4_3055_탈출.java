

import java.io.*;
import java.util.*;
public class Bj_G4_3055_탈출 {

	static int R,C;
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static ArrayDeque<Point> waterQueue = new ArrayDeque<>();
	static ArrayDeque<Point> hedgeQueue = new ArrayDeque<>();

	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i=0;i<R;i++){
			String row = br.readLine();
			for(int j=0;j<C;j++){
				map[i][j] = row.charAt(j);
				if(map[i][j]=='*') waterQueue.offer(new Point(i,j));
				if(map[i][j]=='S') hedgeQueue.offer(new Point(i,j,0));
			}
		}
		bfs();
		System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
		br.close();
	}

	static void bfs(){
		while(!hedgeQueue.isEmpty()){
			int waterSize = waterQueue.size();
			for(int w=0;w<waterSize;w++){
				Point water = waterQueue.poll();
				for(int d=0;d<4;d++){
					int ni = water.i + di[d];
					int nj = water.j + dj[d];
					if(0<=ni && ni<R && 0<=nj && nj<C && map[ni][nj]=='.'){
						map[ni][nj]='*';
						waterQueue.offer(new Point(ni,nj));
					}
				}
			}


			int hedgeSize = hedgeQueue.size();
			for(int h=0;h<hedgeSize;h++){
				Point hedge = hedgeQueue.poll();
				for(int d=0;d<4;d++){
					int ni = hedge.i + di[d];
					int nj = hedge.j + dj[d];
					int time = hedge.time;
					if(0<=ni && ni<R && 0<=nj && nj<C){
						if(map[ni][nj]=='D'){
							answer = Math.min(answer,time+1);
							return;
						}
						if(map[ni][nj]=='.'){
							map[ni][nj]='S';
							hedgeQueue.offer(new Point(ni,nj,time+1));
						}
					}
				}
			}
		}
	}
	static class Point{
		int i,j;
		int time;
		public Point(int i,int j){
			this.i = i;
			this.j = j;
		}
		public Point(int i,int j,int time){
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}
}
