import java.io.*;
import java.util.*;
public class Bj_S1_1992_쿼드트리 {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<N;j++)
                video[i][j] = row.charAt(j)-'0';
            
        }
        compression(0, 0, N);
        System.out.println(sb.toString());
        br.close();

    }
    static void compression(int starti,int startj,int size){
        int sum = 0;
        for(int i=starti;i<starti+size;i++){
            for(int j=startj;j<startj+size;j++){
                sum += video[i][j];
            }
        }
        if(sum==0 || sum==size*size){ // 영상이 모두 0 혹은 1로 되어 있는 경우 
            sb.append(sum==0?sum:1);
            return;
        }
        // 0과 1이 섞여 있는 경우
        int half = size/2;
        sb.append("(");
        compression(starti, startj, half);
        compression(starti, startj+half, half);
        compression(starti+half, startj, half);
        compression(starti+half, startj+half, half);
        sb.append(")");
    }
}