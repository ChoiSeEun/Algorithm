import java.util.*;
import java.io.*;

public class Bj_G5_2470_두용액 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
		
		int start = 0;
		int end = N-1;
		int min = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;
		
		while(true) {
			if(start>=end) break;
			int now = array[start] + array[end];
			
			// 특성값 0이 만들어졌으면 바로 break
			if(now==0) {
				minStart = start;
				minEnd = end;
				break;
			}
			// 0과의 차이값이 더 작은 경우 갱신 
			if(Math.abs(0-min)>Math.abs(0-now)) {
				min = now;
				minStart = start;
				minEnd = end;
			}
			if(now<0) start++;
			else end--;
		}
		System.out.println(array[minStart] + " "+array[minEnd]);
		br.close();
	}
}
