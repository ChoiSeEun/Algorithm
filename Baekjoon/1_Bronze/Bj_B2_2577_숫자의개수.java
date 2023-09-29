import java.io.*;
import java.util.*;
public class Bj_B2_2577_숫자의개수 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int result = A*B*C;
        int[] count = new int[10];

        while(result>0){
            count[result%10]++;
            result /= 10;
        }
        for(int i=0;i<10;i++)
            System.out.println(count[i]);
        sc.close();
    }
}
