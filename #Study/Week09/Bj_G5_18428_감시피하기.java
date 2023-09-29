package ssafy.study.Week09;

import java.io.*;
import java.util.*;

public class Bj_G5_18428_감시피하기 {

	static int N;
	static char[][] map;
	static List<Point> teacher = new ArrayList<>();
	
	static class Point{
		int x,y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = st.nextToken().charAt(0);
				
				if(map[i][j]=='T')
					teacher.add(new Point(i,j));
			}
		}
		combination(0,0);
		System.out.println("NO");
	}
	static void combination(int cnt,int index) {
		if(cnt==3) {
//			System.out.println(Arrays.toString(objectInstall));
			boolean result = can_watch();
			if(!result) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		if(index>=N*N) return;
		
		int i = index/N;
		int j = index%N;
		if(map[i][j]=='X') {
			map[i][j] = 'O';
			combination(cnt+1,index+1);
			map[i][j] = 'X';
		}
		combination(cnt,index+1);
	}
	
	// 선생님 기준 감시할 수 있는지 확인
	// 학생을 감시할 수 있으면 true return 
	static boolean can_watch() {
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		for(int t=0;t<teacher.size();t++) {
			int i = teacher.get(t).x;
			int j = teacher.get(t).y;
			for(int d=0;d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				while(0<=ni && ni<N && 0<=nj && nj<N) {
					if(map[ni][nj]=='S') return true;
					if(map[ni][nj]=='O') break;
					ni += di[d];
					nj += dj[d];
				}
			}
		}
		return false;
	}

}

