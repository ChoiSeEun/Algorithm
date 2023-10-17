import java.io.*;
import java.util.*;

public class Bj_G5_1041_주사위 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dice = new int [6];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<6;i++){
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		// 마주보는 두 변 중 최소값 구하기 
		int[] minNum = new int[3];
		minNum[0] = Math.min(dice[0], dice[5]); // A와 F 중 최소
		minNum[1] = Math.min(dice[1], dice[4]); // B와 E 중 최소 
		minNum[2] = Math.min(dice[2], dice[3]); // C와 D 중 최소 
		Arrays.sort(minNum);
		
		
		long sum =0;
		if(N==1) {
			Arrays.sort(dice);
			for(int i=0;i<5;i++)
				sum += dice[i];
		}
		// 3면 보이는 사각형 : 4
		// 2면 보이는 사각형 : 8(n-2)+4
		// 1면 보이는 사각형 : 5(n-2)^2 + 4(n-2)
		else {
			sum += minNum[0]*(5L*(N-2)*(N-2)+4 *(N-2));
			sum += (minNum[0]+minNum[1])*(8*(N-2)+4);
			sum += (minNum[0]+minNum[1]+minNum[2])*4;
		}
		System.out.println(sum);
		br.close();
	}
}
