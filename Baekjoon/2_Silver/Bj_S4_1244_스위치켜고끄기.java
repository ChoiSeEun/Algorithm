import java.util.*;
import java.io.*;
public class Bj_S4_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] switches = new int [N];
		for (int i=0;i<N;i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		int students = Integer.parseInt(br.readLine());
		for(int student=0;student<students;student++) {
			st = new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			switch(sex) {
				case 1:
					for (int i=num;i<=N;i+=num)
						switches[i-1] = Math.abs(switches[i-1]-1);
					break;
				case 2:
					int i=1;
					num -= 1;
					while(true) {
						if (num-i<0||num+i>=N) break;
						if (switches[num-i]!=switches[num+i]) break;
						i++;
					}
					for(int j=num-i+1;j<=num+i-1;j++)
						switches[j] = Math.abs(switches[j]-1);
					break;
			}
		}
		
		for(int i=0; i<switches.length; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
}
