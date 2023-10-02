import java.io.*;
import java.util.*;

public class Bj_B3_2884_알람시계 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M>=45) System.out.println(H+" "+(M-45));
        else{
            M += 60;
            H = H==0?24:H;
            System.out.println((H-1)+" "+(M-45));
        }
        sc.close();
    }
}
