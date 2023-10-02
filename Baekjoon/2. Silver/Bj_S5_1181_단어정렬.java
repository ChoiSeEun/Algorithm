import java.io.*;
import java.util.*;


public class Bj_S5_1181_단어정렬 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] wordList = new String[N];
		
		for(int i=0;i<N;i++) 
			wordList[i] = br.readLine();
		
		Arrays.sort(wordList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2);
				else return Integer.compare(o1.length(),o2.length());
			}
			
		});
		
		System.out.println(wordList[0]);
		for(int i=1;i<N;i++) {
			if(!wordList[i].equals(wordList[i-1])) System.out.println(wordList[i]);
		}
		br.close();
	}

}
