import java.util.*;
import java.io.*;
public class Swea_d2_1954_달팽이숫자{
	
	static int[][] arr;
	static int N,num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			num = 1;
			snail(0,0,N);
			
			System.out.println("#"+tc);
			for (int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(arr[i][j]+" ");
				System.out.println();
			}
		}
	}
	static void snail(int starti,int startj,int move) {
		// 현재 위치 저장 변수 
		int ni=starti;
		int nj=startj;

		arr[ni][nj] = num++; 

		for(int k=0;k<move-1;k++) // -> 오른쪽 방향 N-1개 채우기
			arr[ni][++nj] = num++;
		for(int k=0;k<move-1;k++) // 아래 방향 N-1개 채우기
			arr[++ni][nj] = num++;
		for(int k=0;k<move-1;k++) // <- 왼쪽 방향 N-1개 채우기
			arr[ni][--nj] = num++;
		for(int k=0;k<move-2;k++) // 위 방향 N-2개 채우기
			arr[--ni][nj] = num++;

		if(num>N*N) return;
		snail(ni,nj+1,move-2);
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
