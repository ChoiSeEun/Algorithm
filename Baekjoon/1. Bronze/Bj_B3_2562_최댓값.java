import java.io.*;
import java.util.*;
public class Bj_B3_2562_최댓값 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int max=0;
        int maxIdx=0;
        for(int i=0;i<9;i++){
            int num = sc.nextInt();
            if(num>max){
                max = num;
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx+1);
    }
}
