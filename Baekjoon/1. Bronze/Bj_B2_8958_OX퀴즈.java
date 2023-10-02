import java.io.*;
import java.util.*;
public class Bj_B2_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=0;tc<T;tc++){
			String result = br.readLine();
			int totalScore = 0;
			int questionScore = 0;
			for(int i=0;i<result.length();i++) {
				if(result.charAt(i)=='O') {
					questionScore++;
					totalScore += questionScore;
				}
				else {
					questionScore = 0;
				}
			}
			System.out.println(totalScore);
		}
		br.close();
	}

}
