import java.io.*;
import java.util.*;

public class Bj_S5_2751_수정렬하기2 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] cnt = new boolean[2000001];	
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			cnt[num+1000000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		

		for(int i=0;i<=2000000;i++) {
			if(cnt[i]) sb.append((i)-1000000).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
