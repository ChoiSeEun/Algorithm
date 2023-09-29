import java.io.*;
import java.util.*;

public class Bj_B5_1330_두수비교하기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if(A>B) System.out.println(">");
        else if(A<B) System.out.println("<");
        else System.out.println("==");
        sc.close();
    }
}
