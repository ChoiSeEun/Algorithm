import java.io.*;
import java.util.*;

public class Bj_B5_2438_별찍기1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<=N;i++){
            for(int j=0;j<i;j++)
                System.out.print("*");
            System.out.println();
        }
        sc.close();
    }
}
