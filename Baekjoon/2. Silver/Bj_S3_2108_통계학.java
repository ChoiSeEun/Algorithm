import java.io.*;
import java.util.*;

public class Bj_S3_2108_통계학 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		double sum = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		int max = -1;
		int mod = arr[0];
		boolean check = false;
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]==arr[i+1]) cnt++;
			else cnt = 0;
			
			if(max<cnt) {
				max = cnt;
				mod = arr[i];
				check = true;
			} else if(max==cnt && check) {
				mod = arr[i];
				check = false;
			}
		}
		
		System.out.println(Math.round(sum/N));
		System.out.println(arr[N/2]);
		System.out.println(mod);
		System.out.println(arr[N-1]-arr[0]);
	}
}
