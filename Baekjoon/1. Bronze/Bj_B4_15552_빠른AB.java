
import java.io.*;
import java.util.*;

public class Bj_B4_15552_빠른AB {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       StringBuilder sb = new StringBuilder();
       int T = Integer.parseInt(br.readLine());
       for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A+B).append("\n");
       }
       System.out.println(sb.toString());
       br.close();
    }
}
