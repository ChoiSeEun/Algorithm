
import java.io.*;
import java.util.*;
public class Bj_B2_10809_알파벳찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int alpha[] = new int[26];
		
		Arrays.fill(alpha, -1);
		for(int i=0;i<word.length();i++) {
			char now = word.charAt(i);
			if(alpha[now-'a']==-1) alpha[now-'a'] = i;
		}
		for(int i=0;i<26;i++) {
			if(i!=0) System.out.print(" ");
			System.out.print(alpha[i]);
		}
		br.close();
	}

}
