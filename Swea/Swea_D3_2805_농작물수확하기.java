import java.util.*;
import java.io.*;

public class Swea_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			// 농장 크기 
			int N = Integer.parseInt(br.readLine());
			int [][] farm = new int [N][N];
			// 농장 내 농작물 가치 입력 받기 
			for(int i=0;i<N;i++) {
				String temp = br.readLine();
				for (int j=0;j<N;j++)
					farm[i][j] = Integer.parseInt(Character.toString(temp.charAt(j)));
			}
			int value = 0;
			// 마름모 위쪽
			for(int i=0;i<=N/2;i++) {
				for(int j=N/2-i;j<=(N-1)-N/2+i;j++)
					value += farm[i][j];
			}
			// 마름모 아래쪽 
			for(int i=1;i<N-N/2;i++) {
				for(int j=i;j<N-i;j++)
					value += farm[N/2+i][j];
			}
			sb.append("#").append(tc).append(" ").append(value).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

