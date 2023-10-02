import java.util.*;
import java.io.*;

public class Bj_S3_15650_N과M2 {

	static int N,M;
	static int[] selected;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int [M];
		combination(0,1);
		
	}
	static void combination(int cnt,int start) {
		if (cnt==M) {
			for (int i=0;i<selected.length;i++)
				System.out.print(selected[i]+" ");
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {
			selected[cnt] = i;
			combination(cnt+1,i+1);
		}
	}

}
