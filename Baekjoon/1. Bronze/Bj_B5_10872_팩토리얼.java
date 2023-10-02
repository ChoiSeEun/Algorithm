import java.io.*;
import java.util.*;
public class Bj_B5_10872_팩토리얼 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int fact = 1;
        for(int i=1;i<=N;i++)
            fact *= i;
        System.out.println(fact);
        sc.close();
    }
}
