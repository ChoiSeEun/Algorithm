import java.io.*;
import java.util.*;
public class Bj_B3_10250_ACM호텔 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			
			if(N%H==0) sb.append((H*100)+(N/H)).append("\n");
			else sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n');
		}
		System.out.println(sb.toString());
		br.close();
	}
}
