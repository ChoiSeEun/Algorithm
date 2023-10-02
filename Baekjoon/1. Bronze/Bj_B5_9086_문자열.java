import java.io.*;
import java.util.*;
public class Bj_B5_9086_문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            String str = br.readLine();
            int len = str.length();
            System.out.println(str.charAt(0)+""+str.charAt(len-1));
        }
        br.close();
    }
}
