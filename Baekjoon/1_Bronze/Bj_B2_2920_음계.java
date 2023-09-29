
import java.io.*;
import java.util.*;
public class Bj_B2_2920_음계 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] array = new int[8];
		for(int i=0;i<8;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean asc = true;
		boolean des = true;
		
		for(int i=0;i<7;i++) {
			if(array[i+1]>array[i]) des = false;
			if(array[i+1]<array[i]) asc = false;
		}
		if(asc) System.out.println("ascending");
		else if(des) System.out.println("descending");
		else System.out.println("mixed");
		br.close();
	}
}
