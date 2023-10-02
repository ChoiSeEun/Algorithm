import java.io.*;
import java.util.*;

public class Bj_B1_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(N1,N2);
		int lcm = N1*N2 / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
		br.close();
	}
	static int gcd(int a,int b) {
		if(a%b==0) return b;
		else return gcd(b,a%b);
	}
}
