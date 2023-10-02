
import java.io.*;
import java.util.*;
public class Bj_B2_3052_나머지 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<10;i++) {
			int num = Integer.parseInt(br.readLine());
			set.add(num%42);
		}
		System.out.println(set.size());
		br.close();
	}

}
