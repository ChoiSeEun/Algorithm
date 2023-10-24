import java.io.*;
import java.util.*;

public class Bj_S4_1920_수찾기 {

	static int[] array;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int now = Integer.parseInt(st.nextToken());
			sb.append(search(now)).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static int search(int now) {
		int start = 0;
		int end = array.length-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			if(array[mid]==now) return 1;
			else if(array[mid]>now) end = mid-1;
			else start = mid+1;
		}
		return 0;
	}
} 
