
import java.io.*;
import java.util.*;

public class Bj_B5_2475_검증수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        double num = 0;
        for(int i=0;i<5;i++){
            int n = Integer.parseInt(st.nextToken());
            num += Math.pow((double)n,2);
        }
        System.out.println((int)(num%10));
        br.close();
    }
}
