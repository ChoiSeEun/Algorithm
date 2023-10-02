import java.util.*;
import java.io.*;

public class Bj_G5_2493_탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peekLast()[1]>=top){
                    System.out.print(stack.peekLast()[0]+" ");
                    break;
                }
                stack.pollLast();
            }
            if(stack.isEmpty())
                System.out.print("0 ");
            stack.offerLast(new int[] {i,top});
        }
        br.close();
    }
}
