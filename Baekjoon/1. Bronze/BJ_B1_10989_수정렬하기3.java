import java.io.*;
import java.util.*;

public class BJ_B1_10989_수정렬하기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10000;i++) {
			if(arr[i]!=0) {
				for(int j=0;j<arr[i];j++)
					sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}
