import java.io.*;
import java.util.*;
public class Bj_B1_1259_팰린드롬수 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int input = sc.nextInt();
			if(input==0) break;
			
			String num = Integer.toString(input);
			StringBuilder sb = new StringBuilder();
			while(input>0) {
				sb.append(input%10);
				input /= 10;
			}
			
			if(num.equals(sb.toString())) System.out.println("yes");
			else System.out.println("no");
		}
		sc.close();
	}
}
