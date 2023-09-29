import java.util.*;
import java.io.*;

public class Swea_D2_2001_파리퇴치 {

	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			int maxSum = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sum = cal_fly(i,j);
					if (sum>maxSum) maxSum = sum;
				}
			}
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static int cal_fly(int starti,int startj) {
		int sum = 0;
		for(int i=starti;i<starti+M;i++) {
			for(int j=startj;j<startj+M;j++) {
				if(i<0||i>=N||j<0||j>=N) continue;
				sum += arr[i][j];
			}
		}
		return sum;
	}
}
