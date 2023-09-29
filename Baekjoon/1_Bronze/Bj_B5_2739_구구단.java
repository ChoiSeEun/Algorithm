import java.io.*;
import java.util.*;
public class Bj_B5_2739_구구단 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<10;i++){
            System.out.println(N+" * "+i+" = "+(N*i));
        }
        sc.close();
    }
}
