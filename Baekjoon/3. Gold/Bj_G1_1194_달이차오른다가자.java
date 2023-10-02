import java.io.*;
import java.util.*;
public class Main_bj_g1_1194_달이차오른다가자 {

    static int N,M;
    static char[][] map;
    static boolean[][][] visited;

    static class Node{
        int x,y;
        int key;
        int cost;
        public Node(int x,int y,int cost,int key){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[N][M][64];

        int starti = 0,startj=0;
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = row.charAt(j);
                if(map[i][j]=='0'){
                    starti = i;
                    startj = j;
                }
            }
        }
        System.out.println(bfs(starti,startj));
        br.close();
    }
    static int bfs(int i,int j){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        queue.offer(new Node(i, j, 0, 0));
        visited[i][j][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(map[now.x][now.y]=='1') return now.cost;

            for(int d=0;d<4;d++){
                int ni = now.x + di[d];
                int nj = now.y + dj[d];

                if(isAvaiable(ni, nj) && map[ni][nj]!='#' && !visited[ni][nj][now.key]){
                    // 열쇠인 경우 
                    if('a' <= map[ni][nj] && map[ni][nj] <= 'f'){
                        int key = now.key | (1<<map[ni][nj]-'a');
                        queue.offer(new Node(ni,nj,now.cost+1,key));
                        visited[ni][nj][key] = true; 
                    }
                    // 문인 경우
                    else if('A' <= map[ni][nj] && map[ni][nj] <= 'F'){
                        boolean keyHold = (now.key & (1<<(map[ni][nj]-'A')))!=0;
                        if(keyHold){
                            queue.offer(new Node(ni,nj,now.cost+1,now.key));
                            visited[ni][nj][now.key] = true;
                        }
                    }
                    // 빈칸인 경우 
                    else{
                        queue.offer(new Node(ni,nj,now.cost+1,now.key));
                        visited[ni][nj][now.key] = true;
                    }
                }
            }
        }
        return -1;
    }
    static boolean isAvaiable(int x,int y){
        if(0<=x && x<N && 0<=y && y<M) return true;
        return false;
    }
}
