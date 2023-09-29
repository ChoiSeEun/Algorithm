import java.util.*;
import java.io.*;


public class Swea_d1_2072_홀수만더하기{

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d1_2072.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // for 입력 
		StringBuilder sb = new StringBuilder(); // for 출력 
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int ans = 0;
			for (int i=0;i<10;i++) {
				int num = Integer.parseInt(st.nextToken()); // nextToken은 기본 문자 
				if (num%2!=0)
					ans += num;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
		
	}

}
