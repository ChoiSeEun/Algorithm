import java.util.*;
import java.io.*;

public class Bj_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] arr = new int [N];
		
		st = new StringTokenizer(br.readLine()," ");
		int accSum = 0;
		for(int i=0;i<N;i++) {
			accSum +=  Integer.parseInt(st.nextToken());
			arr[i] = accSum;
		}
		
		for(int cnt=0;cnt<M;cnt++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start==1)
				System.out.println(arr[end-1]);
			else
				System.out.println(arr[end-1]-arr[start-2]);
		}
	}

}
