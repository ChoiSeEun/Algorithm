
import java.io.*;
import java.util.*;

public class Bj_S2_1654_랜선자르기 {

	static long[] arr;
	static int K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new long[K];
		long maxLen = Long.MIN_VALUE;
		for(int i=0;i<K;i++) {
			arr[i] = Long.parseLong(br.readLine());
			maxLen = Math.max(maxLen, arr[i]);
		}
		
		long start = 1;
		long end = maxLen;
		long answer = 0;
		
		while(start<=end) {
			long mid = (start+end)/2;
			int cnt = makeLan(mid);
			
			if(cnt<N) end = mid-1;
			else {
				answer = Math.max(answer, mid);
				start = mid+1;
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	static int makeLan(long mid) {
		int cnt = 0;
		for(int i=0;i<K;i++) {
			cnt += arr[i]/mid;
		}
		return cnt;
	}
}
