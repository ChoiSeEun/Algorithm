import java.io.*;
import java.util.*;

public class Bj_B5_2744_대소문자바꾸기 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c))
                System.out.print(Character.toLowerCase(c));
            else
                System.out.print(Character.toUpperCase(c));
        }
    }
}
