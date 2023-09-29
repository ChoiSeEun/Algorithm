import java.io.*;
import java.util.*;
public class Bj_B4_2439_별찍기2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            for(int j=0;j<N-i;j++)
                System.out.print(" ");
            for(int k=0;k<i;k++)
                System.out.print("*");
            System.out.println();
        }

        sc.close();
    }
}
