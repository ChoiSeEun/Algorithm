import java.io.*;
import java.util.*;
public class Bj_G4_10026_적록색약 {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        grid = new char[N][N];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<N;j++)
                grid[i][j] = row.charAt(j);
        }
        // 적록색약이 아닌 사람
        visited = new boolean[N][N];
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) {
                    bfs(i,j);
                    count ++;
                }
            }
        }
        sb.append(count).append(" ");
        
        // 적록색약인 사람
        // 적록색약인 경우 빨강과 초록을 빨강으로 통일 
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]=='G') grid[i][j] = 'R';
            }         
        }
        // 바꾼 후 탐색 진행
        visited = new boolean[N][N];
        count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) {
                    bfs(i,j);
                    count ++;
                }
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
        br.close();
    }
    static void bfs(int i,int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N && grid[ni][nj]==grid[i][j] && !visited[ni][nj]){
                    queue.offer(new int[]{ni,nj});
                    visited[ni][nj] = true;
                }
            }
        }

    }
}
