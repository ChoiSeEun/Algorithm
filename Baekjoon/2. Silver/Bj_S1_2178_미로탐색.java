import java.io.*;
import java.util.*;
public class Bj_S1_2178_미로탐색 {
    
    static int N,M;
    static int[][]map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++)
                map[i][j] = row.charAt(j)-'0';
        }
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
        br.close();
    }
    static void bfs(int i,int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        queue.offer(new int[]{i,j});
        
        while(!queue.isEmpty()){
            int [] poll = queue.poll();
            i = poll[0];
            j = poll[1];

            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M && map[ni][nj]==1){
                    queue.offer(new int[]{ni,nj});
                    map[ni][nj] = map[i][j]+1;
                }
            }
        }
    }
}
