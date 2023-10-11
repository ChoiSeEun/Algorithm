import java.io.*;
import java.util.*;
public class SWEA_D3_5607_조합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long result = nCr(N,R,1234567891);
			
			sb.append("#").append(tc).append(" ").append((int)result).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static long nCr(int n,int r,int p) {
		if(r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1;i<=n;i++)
			fac[i] = fac[i-1]*i%p;
		
		return (fac[n]*power(fac[r],p-2,p)%p*power(fac[n-r],p-2,p)%p)%p;
	}
	
	static long power(long x,long y,long p) {
		long res = 1L;
		x = x%p;
		while(y>0) {
			if(y%2==1)
				res = (res*x)%p;
			y = y>>1;
			x = (x*x)%p;
		}
		return res;
	}
}
