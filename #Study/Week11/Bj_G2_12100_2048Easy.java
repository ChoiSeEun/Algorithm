import java.io.*;
import java.util.*;
public class Bj_G2_12100_2048Easy {
    static int N;
    static int[][]map,origin;
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int maxNum =0;
    static int[] perArray = new int[5];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        origin = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(0);
        System.out.println(maxNum);
        br.close();
    }
    static void permutation(int depth){
        if(depth==5){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++)
                    map[i][j] = origin[i][j];
            }

            for(int p=0;p<5;p++){
                visited = new boolean[N][N];
                int dir = perArray[p];
                switch (dir){
                    case 0: // 상
                        for(int i=0;i<N;i++){
                            for(int j=0;j<N;j++){
                                move(i,j,dir);
                            }
                        }
                        break;
                    case 1: // 우
                        for(int i=N-1;i>=0;i--){
                            for(int j=0;j<N;j++){
                                move(j,i,dir);
                            }
                        }
                        break;
                    case 2: // 하
                        for(int i=N-1;i>=0;i--){
                            for(int j=0;j<N;j++){
                                move(i,j,dir);
                            }
                        }
                        break;
                    case 3: // 좌
                        for(int i=0;i<N;i++){
                            for(int j=0;j<N;j++){
                                move(j,i,dir);
                            }
                        }
                        break;
                }
                int nowMax = 0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++)
                        nowMax = Math.max(nowMax,map[i][j]);
                }
                maxNum = Math.max(maxNum,nowMax);
            }
            return;
        }
        for(int i=0;i<4;i++){
            perArray[depth] = i;
            permutation(depth+1);
        }
    }
    static void move(int i,int j,int dir){
        if(map[i][j]==0) return;

        while(true){
            int ni = i + di[dir];
            int nj = j + dj[dir];

            if(ni<0 || nj<0 || ni>=N || nj>=N) return;
            if(visited[ni][nj]) return;

            if(map[ni][nj]==map[i][j]){
                visited[ni][nj] = true;
                map[ni][nj] *= 2;
                map[i][j] = 0;
                return;
            } else if(map[ni][nj]!=0) return;

            map[ni][nj] = map[i][j];
            map[i][j] = 0;
            i = ni;
            j = nj;
        }
    }
}
