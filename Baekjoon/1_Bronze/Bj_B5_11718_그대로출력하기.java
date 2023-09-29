
import java.io.*;
import java.util.*;
public class Bj_B5_11718_그대로출력하기 {
   public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str==null || str.isEmpty()) break;
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
   } 
}
