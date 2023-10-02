import java.io.*;
import java.util.*;
public class Bj_S3_1929_소수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i=2;i<=(int)(Math.sqrt(N));i++) {
			if(prime[i]) {
				int j = 2;
				while(i*j<=N) {
					prime[i*j] = false;
					j++;
				}
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(prime[i]) System.out.println(i);
		}
		br.close();
		
	}
}
