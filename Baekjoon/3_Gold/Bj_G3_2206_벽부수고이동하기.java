import java.io.*;
import java.util.*;
public class Bj_G3_2206_벽부수고이동하기 {
    static int N,M;
    static int[][]map;
    static boolean[][][] visited;

    static class node{
        int i,j;
        int cnt;
        boolean destoryed;
        public node(int i,int j,int cnt,boolean destoryed){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destoryed = destoryed;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++)
                map[i][j] = row.charAt(j)-'0';
        }
        int answer = bfs(0,0);
        System.out.println(answer);
        br.close();
    }
    static int bfs(int i,int j){
        ArrayDeque<node> queue = new ArrayDeque<>();
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        queue.offer(new node(i,j,1,false));
        visited[0][i][j] = true;

        while(!queue.isEmpty()){
            node now = queue.poll();
            if(now.i==N-1 && now.j==M-1) return now.cnt;

            for(int d=0;d<4;d++){
                int ni = now.i + di[d];
                int nj = now.j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M){
                    if(map[ni][nj]==0){
                        if(now.destoryed && !visited[1][ni][nj]){
                            queue.offer(new node(ni,nj,now.cnt+1,true));
                            visited[1][ni][nj] = true;
                        }
                        if(!now.destoryed && !visited[0][ni][nj]){
                            queue.offer(new node(ni,nj,now.cnt+1,false));
                            visited[0][ni][nj] = true;
                        }
                    }
                    else{
                        if(!now.destoryed && !visited[0][ni][nj]){
                            queue.offer(new node(ni,nj,now.cnt+1,true));
                            visited[0][ni][nj] = true;
                        }
                    } 
                }
            }
        }
        return -1;
    }
}