import java.util.*;
import java.io.*;
public class Bj_S2_4963_섬의개수 {
    static int W,H;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W==0 && H==0) break;
            else{
                map = new int[H][W];
                visited = new boolean[H][W];
                for(int i=0;i<H;i++){
                    st = new StringTokenizer(br.readLine(), " ");
                    for(int j=0;j<W;j++)
                        map[i][j] = Integer.parseInt(st.nextToken());
                }
                int count = 0;
                for(int i=0;i<H;i++){
                    for(int j=0;j<W;j++){
                        if(map[i][j]==1 && !visited[i][j]){
                            bfs(i,j);
                            count++;
                        }
                    }
                }
                sb.append(count).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void bfs(int i,int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 상하좌우 왼쪽위 오른쪽위 왼쪽아래 오른쪽아래
        int[] di = {-1,1,0,0,-1,-1,1,1};
        int[] dj = {0,0,-1,1,-1,1,-1,1};
        
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            for(int d=0;d<8;d++){ // 8방 탐색 
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<H && 0<=nj&&nj<W && map[ni][nj]==1 && !visited[ni][nj]){
                    queue.offer(new int[]{ni,nj});
                    visited[ni][nj] = true;
                }
            }
        }
    }
}
