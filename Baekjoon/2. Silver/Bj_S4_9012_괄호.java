import java.util.*;
import java.io.*;
public class Bj_S4_9012_괄호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			String now = br.readLine();
			if(check(now)) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static boolean check(String now) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		int len = now.length();
		
		for(int i=0;i<len;i++) {
			if(now.charAt(i)=='(') stack.offerLast(now.charAt(i));
			else {
				if(stack.isEmpty()) return false;
				if(stack.peekLast()=='(') stack.pollLast();
				else stack.offerLast(now.charAt(i));
			}
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
}
