package ssafy.study.Week06;

import java.io.*;
import java.util.*;

public class Bj_G1_1113_수영장만들기 {
    static int N,M;
    static int[][]map;
    static boolean[][] visited; // 방문여부 배열 
    static int water; // 채워지는 물의 양 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        int maxHeight = 0;
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = row.charAt(j)-'0';
                // 최대 높이 저장 
                if(map[i][j]>maxHeight) maxHeight = map[i][j];
            }
        }
        // 높이 1부터 최대 높이까지 반복
        for(int h=1;h<=maxHeight;h++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==h && !visited[i][j])
                        bfs(i,j,h);
                }
            }
        }
        System.out.println(water);
        br.close();
    }
    private static void bfs(int i,int j,int h){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        List<int[]> tempWater = new ArrayList<>(); // 물을 채워넣을 수 있는 위치 임시 저장
        int minHeight = Integer.MAX_VALUE;
        boolean flood = false;

        visited[i][j] = true;
        queue.offer(new int[]{i,j});
        tempWater.add(new int[]{i,j});

        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            // 가장 자리인 경우 물이 고일 수 없음
            if(poll[0]==0 || poll[0]==N-1 || poll[1]==0 || poll[1]==M-1) flood = true;

            for(int d=0;d<4;d++){
                int ni = poll[0] + di[d];
                int nj = poll[1] + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M){
                    // 물이 고일 수 있는 위치
                    if(!visited[ni][nj] && map[ni][nj]==h){
                        visited[ni][nj] = true;
                        queue.offer(new int[]{ni,nj});
                        tempWater.add(new int[]{ni,nj});
                    }
                    // 주위에 자신보다 작은 높이가 있으면 고일 수 없음
                    if(map[ni][nj]<h) flood = true;

                    if(map[ni][nj]>h) minHeight = Math.min(minHeight,map[ni][nj]);

                }
            }
        }
        // 물이 흘러넘치지 않았다면 최소 높이만큼 물을 채우기 
        if(!flood){
            water += tempWater.size() * (minHeight-h);
            for(int t=0;t<tempWater.size();t++){
                int[] temp = tempWater.get(t);
                map[temp[0]][temp[1]] = minHeight;
                visited[temp[0]][temp[1]] = false;
            }
        }
    }
}