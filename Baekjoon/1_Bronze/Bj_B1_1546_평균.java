import java.io.*;
import java.util.*;

public class Bj_B1_1546_평균 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		double maxScore = Double.MIN_VALUE;
		for(int i=0;i<N;i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			maxScore = Math.max(maxScore, arr[i]);
		}
		double sum = 0;
		for(int i=0;i<N;i++) {
			arr[i] = arr[i]/maxScore*100;
			sum += arr[i];
		}
		System.out.println(sum/N);
		br.close();
	}
}
