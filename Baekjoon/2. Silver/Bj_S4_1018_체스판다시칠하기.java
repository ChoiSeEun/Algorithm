
import java.io.*;
import java.util.*;
public class Bj_S4_1018_체스판다시칠하기 {
    static int N,M;
    static char[][] board;
    static int answer = Integer.MAX_VALUE;
    static char[] color = {'W','B'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++)
                board[i][j] = row.charAt(j);
        }
        for(int i=0;i+8<=N;i++){
            for(int j=0;j+8<=M;j++){
                checkChess(i,j,0);
                checkChess(i,j,1);
            }
        }
        System.out.println(answer);
        br.close();
    }
    static void checkChess(int startN,int startM,int startIndex){
        int cnt = 0;
        int nextIndex = (startIndex==0)?1:0;
        int remain = startM%2;

        for(int i=startN;i<startN+8;i++){
            for(int j=startM;j<startM+8;j++){
                if(j%2==remain && board[i][j]!=color[startIndex]) {
//                    System.out.println("startColor");
//                    System.out.println(i + " "+j);
                    cnt++;
                }
                if(j%2!=remain && board[i][j]!=color[nextIndex]) {
//                    System.out.println("nextColor");
//                    System.out.println(i + " "+j);
                    cnt++;
                }
            }
            startIndex = Math.abs(startIndex-1);
            nextIndex = Math.abs(nextIndex-1);
        }
        answer = Math.min(answer,cnt);
    }
}
