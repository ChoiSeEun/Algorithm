import java.io.*;
import java.util.*;

public class Bj_S2_2961_도영이가만든맛있는음식 {

	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int diff = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(diff);
		br.close();
	}
	static void subset(int depth) {
		if(depth==N) {
			int sour = 1;
			int bitter = 0;
			for(int i=0;i<visited.length;i++) {
				if (visited[i]) {
					sour = sour*arr[i][0];
					bitter = bitter+arr[i][1];
				}
			}
			if(sour!=0 & bitter!=0 & diff>Math.abs(sour-bitter))
				diff = Math.abs(sour-bitter);
			return;
		}
		visited[depth] = true;
		subset(depth+1);
		visited[depth] = false;
		subset(depth+1);
	}
}
