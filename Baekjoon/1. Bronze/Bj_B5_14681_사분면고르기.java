
import java.io.*;
import java.util.*;
public class Bj_B5_14681_사분면고르기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x>0){
            if(y>0) System.out.println(1);
            else System.out.println(4);
        }else{
            if(y>0) System.out.println(2);
            else System.out.println(3);
        }
        sc.close();
    }
}
