import java.io.*;
import java.util.*;

public class Bj_G4_4485_녹색옷입은애가젤다지 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc=1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            
            int[][]cave = new int[N][N];
            int[][]dist = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            // 0,0에서 시작하도록
            dist[0][0] = cave[0][0];
            // 하, 우 , 상 , 좌 
            // [N-1][N-1] 쪽으로 최대한 가깝게 움직이기 위함 
            int[] di = {1,0,-1,0};
            int[] dj = {0,1,0,-1};

            while(true){
                int min = Integer.MAX_VALUE;
                int minI=0,minJ=0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(!visited[i][j] && min>dist[i][j]){
                            minI = i;
                            minJ = j;
                            min = dist[i][j];
                        }
                    }
                }
                visited[minI][minJ] = true;
                if(minI==N-1 && minJ==N-1) break;
                
                for(int d=0;d<4;d++){
                    int ni = minI+di[d];
                    int nj = minJ+dj[d];

                    if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj] && dist[ni][nj]>dist[minI][minJ]+cave[ni][nj])
                        dist[ni][nj] = dist[minI][minJ]+cave[ni][nj];
                }

            }
            sb.append("Problem ").append(tc++).append(": ").append(dist[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}