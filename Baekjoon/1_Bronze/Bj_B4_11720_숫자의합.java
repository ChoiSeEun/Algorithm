import java.util.*;
import java.io.*;
public class Bj_B4_11720_숫자의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        int sum = 0;
        for(int i=0;i<N;i++){
            int  n = num.charAt(i)-'0';
            sum += n;
        }
        System.out.println(sum);
        br.close();
    }
}
