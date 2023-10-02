import java.io.*;
import java.util.*;
public class Bj_G2_3109_빵집 {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int cnt=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String row = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = row.charAt(j);
            }
        }
        // 첫 번째 열에서 시작 
        for(int i=0;i<R;i++)
            backtracking(i,0,0);
        System.out.println(cnt);
        br.close();

    }
    static boolean backtracking(int i,int j,int depth){
        // 파이프 설치 불가 지점
        if(visited[i][j] || map[i][j]=='x') return false;

        // 파이프 설치 완료
        visited[i][j] = true;
        if(depth==C-1){
            cnt++;
            return true;
        }
        
        int[] di = {-1,0,1};
        int[] dj = {1,1,1};

        for(int d=0;d<3;d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0<=ni&&ni<R && 0<=nj&&nj<C){
                boolean res = backtracking(ni, nj, depth+1);
                if(res) return true; // 이미 답을 찾았다면 해당 경로 탐색 모두 종료하기
            }
        }
        return false;
    }
}
