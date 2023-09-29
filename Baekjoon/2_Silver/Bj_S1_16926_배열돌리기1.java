import java.io.*;
import java.util.*;

public class Bj_S1_16926_배열돌리기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 초기 배열 입력 
        int[][] array = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 반시계 방향 이동 
        int [] di = {0,1,0,-1};
        int [] dj = {1,0,-1,0};

        // 돌릴 사각형의 횟수
        int count = Math.min(N,M)/2;
        // 배열 회전 
        for(int r=0;r<R;r++){
            // 한 번의 회전 당 시각형 다 돌리기 
            for(int c=0;c<count;c++){
                int i = c;
                int j = c;
                int temp = array[i][j]; // 시작값 
                
                int d =0;
                while(d<4){
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(c<=ni&&ni<N-c && c<=nj&&nj<M-c){
                        array[i][j] = array[ni][nj];
                        i = ni;
                        j = nj;
                    }
                    else d++;
                }
                array[c+1][c] = temp;
            }
        }
        // 배열 출력
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                System.out.print(array[i][j]+" ");
            System.out.println();
        }
        br.close();

    }
}
