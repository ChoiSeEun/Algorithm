import java.io.*;
import java.util.*;
public class Bj_B5_27866_문자와문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(word.charAt(i-1));
    }
}
