import java.io.*;
import java.util.*;

public class Bj_G4_2636_치즈 {

	static int N,M;
	static int[][] pan;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int Cheese=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pan = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j]==1) ++Cheese;
			}
		}
		int time=0;
		int meltCheese = 0;
		while(Cheese>0) {
			time++;
			meltCheese = bfs(0,0);
			Cheese -= meltCheese;
		}
		System.out.println(time);
		System.out.println(meltCheese);
		br.close();
		
	}
	static int bfs(int i,int j) {
		int meltCheese = 0;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		boolean[][] visited  = new boolean[N][M];
		
		visited[i][j] = true;
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int [] poll = queue.poll();
			i = poll[0];
			j = poll[1];
			System.out.println(i + " " + j);
			for(int d=0;d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(0<=ni && ni<N && 0<=nj && nj<M && !visited[ni][nj]) {
					visited[ni][nj] = true;
					
					if(pan[ni][nj]==1) {
						pan[ni][nj] = 0;
						meltCheese++;
					} 
					else 
						queue.offer(new int[] {ni,nj});
				}
			}
		}
		return meltCheese;
	}
}
