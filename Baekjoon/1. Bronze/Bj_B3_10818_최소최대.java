import java.io.*;
import java.util.*;

public class Bj_B3_10818_최소최대 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>maxValue) maxValue = num;
            if(num<minValue) minValue = num;
        }
        sb.append(minValue).append(" ").append(maxValue);
        System.out.println(sb.toString());
        br.close();
    }
}
