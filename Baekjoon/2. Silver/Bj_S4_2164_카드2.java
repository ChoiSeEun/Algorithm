import java.util.*;
import java.io.*;

public class Bj_S4_2164_카드2 {
	
	static List<Integer> arr;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new LinkedList<>();
		for(int i=0;i<N;i++)
			arr.add(i, i+1);

		cards(0);
		System.out.println(arr.get(0));
		br.close();
	}
	private static void cards(int cnt) {
		if(cnt==N-1) return;
		arr.remove(0);
		arr.add(arr.size(), arr.get(0));
		arr.remove(0);
		cards(cnt+1);
	}
}
