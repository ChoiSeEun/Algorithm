import java.io.*;
import java.util.*;

public class Bj_S2_2630_색종이만들기 {
    static int white;
    static int blue;
    static int[][] paper;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }
        makeSpace(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }
    static void makeSpace(int starti,int startj,int size){
        int sum = 0;
        for(int i=starti;i<starti+size;i++){
            for(int j=startj;j<startj+size;j++){
                sum += paper[i][j];
            }
        }
        if(sum==0) white++;
        else if(sum==size*size) blue++;
        else{
            makeSpace(starti,startj,size/2);
            makeSpace(starti,startj+size/2, size/2);
            makeSpace(starti+size/2, startj, size/2);
            makeSpace(starti+size/2, startj+size/2, size/2);
        }
    }
}
