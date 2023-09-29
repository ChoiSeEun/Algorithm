import java.io.*;
import java.util.*;

public class Bj_B2_3040_백설공주와일곱난쟁이 {
    static int N = 9,R=7;
    static int[] num = new int [N];
    static int[] right = new int [N];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<N;i++)
            num[i] = Integer.parseInt(br.readLine());
        combination(0, 0);
        br.close();
    }
    static void combination(int depth,int start){
        if(depth==R){
            int sum = 0;
            for(int i=0;i<N;i++)
                sum += right[i];
            if (sum==100){
                for(int i=0;i<R;i++)
                    System.out.println(right[i]);
            }
            return;
        }
        for(int i=start;i<N;i++){
            right[depth] = num[i];
            combination(depth+1, i+1);
        }
    }
}
