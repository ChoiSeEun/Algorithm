import java.util.*;
import java.io.*;

public class Bj_S3_15649_N과M {
	
	// boolean [] visited
	// int [] selected 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [] visited = new boolean [N];
		int [] selected = new int [M];
		permutation(N,visited,selected,0);
		br.close();
	}
	private static void permutation(int N,boolean[] visited,int[]selected,int cnt) {
		if (cnt==selected.length) {
			for(int i=0;i<selected.length;i++)
				System.out.print(selected[i]+ " ");
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i+1;
			permutation(N,visited,selected,cnt+1);
			visited[i] = false;
		}
	}
}
