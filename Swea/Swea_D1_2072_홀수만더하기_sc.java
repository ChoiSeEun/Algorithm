import java.util.*;
import java.io.*;


public class Swea_d1_2072_홀수만더하기_sc {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			int sum = 0;
			for (int i=0;i<10;i++) {
				int num = sc.nextInt();
				if (num%2!=0)
					sum += num;
			}
			System.out.println("#"+tc+" "+sum);

		}
		sc.close();
		
	}

}
