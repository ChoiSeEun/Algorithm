import java.io.*;
import java.util.*;
public class Bj_S5_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt  = 0;
		while(N>=5) {
			cnt += N/5;
			N /=5;
		}
		System.out.println(cnt);
		sc.close();
	}
}
