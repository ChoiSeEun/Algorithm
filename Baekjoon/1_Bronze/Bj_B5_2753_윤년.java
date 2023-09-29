
import java.io.*;
import java.util.*;
public class Bj_B5_2753_윤년 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if((year%4==0 && year%100!=0) || year%400==0)
            System.out.println(1);
        else System.out.println(0);
    }
}
