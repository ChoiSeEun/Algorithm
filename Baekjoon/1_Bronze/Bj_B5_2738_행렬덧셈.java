
import java.io.*;
import java.util.*;
public class Bj_B5_2738_행렬덧셈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                int b = Integer.parseInt(st.nextToken());
                A[i][j] +=b;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                System.out.print(A[i][j]+" ");
            System.out.println();
        }

    }
}
