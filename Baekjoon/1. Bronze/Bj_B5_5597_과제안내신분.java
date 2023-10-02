import java.io.*;
import java.util.*;

public class Bj_B5_5597_과제안내신분 {
    public static void main(String[] args) throws Exception{
        boolean[] homework = new boolean[31];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<28;i++)
            homework[sc.nextInt()] = true;
        
        for(int i=1;i<=30;i++){
            if(!homework[i]) System.out.println(i);
        }
        sc.close();
    }
}
