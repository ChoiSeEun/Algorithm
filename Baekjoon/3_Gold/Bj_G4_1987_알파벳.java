import java.util.*;
import java.io.*;

public class Bj_G4_1987_알파벳 {
    
    static int R,C;
    static char[][] board;
    static int maxCount=0; // 최대의 칸 수 
    static boolean[][] visited; // 칸의 방문여부 저장 
    static boolean[] alpha = new boolean[26]; // 경로가 지난 알파벳 확인 
    // 상하좌우
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++){
            String row = br.readLine();
            for(int j=0;j<C;j++)
                board[i][j] = row.charAt(j);
        }
        dfs(0,0,1);
        System.out.println(maxCount);
        br.close();
    }
    static void dfs(int i,int j,int cnt){

        // 방문 처리
        alpha[board[i][j]-'A'] = true;
        visited[i][j] = true;
        // 상하좌우 이동해보기
        for(int d=0;d<4;d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            // 범위에 해당하고, 방문하지 않은 곳인지 확인
            if(0<=ni&&ni<R && 0<=nj&&nj<C && !visited[ni][nj] && !alpha[board[ni][nj]-'A']){
                dfs(ni,nj,cnt+1);
            }
        }
        if(cnt>maxCount) maxCount = cnt;
        
        // 다음 경로 탐색을 위해 방문 해제
        alpha[board[i][j]-'A'] = false;
        visited[i][j] = false;

    }
}
