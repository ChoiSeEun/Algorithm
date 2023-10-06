import java.io.*;
import java.util.*;
public class SWEA_D9_5656_벽돌깨기 {
    static int N,W,H;
    static int minBlock;
    static int[][] blocks,origin;
    static int[] marbles;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            minBlock = Integer.MAX_VALUE;
            blocks = new int[H][W];
            origin = new int[H][W];
            marbles = new int[N];
            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<W;j++)
                    origin[i][j] =  Integer.parseInt(st.nextToken());
            }
            perm(0);
            sb.append("#").append(tc).append(" ").append(minBlock).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void perm(int depth){
        if(depth==N){
            init();
            broke();
            minBlock = Math.min(minBlock,blockCnt());
            return;
        }
        for(int i=0;i<W;i++){
            marbles[depth] = i;
            perm(depth+1);
        }
    }
    static void init(){
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++)
                blocks[i][j] = origin[i][j];
        }
    }
    static void broke(){
        int x = 0;
        int y = 0;
        for(int j=0;j<N;j++){ // 구슬 하나씩
            for(int i=0;i<H;i++){
                if(blocks[i][marbles[j]]!=0){
                    x = i;
                    y = marbles[j];
                    break;
                }
            }
            bfs(x,y);
            drop();
        }
    }
    static void bfs(int i,int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j,blocks[i][j]});
        blocks[i][j] = 0;

        while(!queue.isEmpty()){
            int[] block = queue.poll();
            int cnt = block[2];
            for(int c=1;c<cnt;c++){
                for(int d=0;d<4;d++){
                    int ni = block[0] + di[d]*c;
                    int nj = block[1] + dj[d]*c;
                    if(0<=ni && ni<H && 0<=nj && nj<W){
                        if(blocks[ni][nj]!=0){
                            queue.offer(new int[]{ni,nj,blocks[ni][nj]});
                            blocks[ni][nj]=0;
                        }
                    }
                }
            }
        }
    }
    static void drop(){
        for(int i=H-2;i>=0;i--){
            for(int j=0;j<W;j++){
                if(blocks[i][j]!=0 && blocks[i+1][j]==0){
                    int block = blocks[i][j];
                    int drop = i+1;
                    while(drop<=H-1 && blocks[drop][j]==0) {
                        blocks[drop][j] = block;
                        blocks[drop-1][j] = 0;
                        ++drop;
                    }
                }
            }
        }
    }
    static int blockCnt(){
        int cnt = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(blocks[i][j]!=0) cnt++;
            }
        }
        return cnt;
    }
}

