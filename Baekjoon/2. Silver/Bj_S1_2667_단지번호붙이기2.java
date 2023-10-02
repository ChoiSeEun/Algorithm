import java.util.*;
import java.io.*;

public class Bj_S1_2667_단지번호붙이기2 {
    
    static int N; // 지도 크기 
    static int[][] map; // 지도 저장 
    // 상우하좌 이동 
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    static boolean[][]visited; // 집의 방문여부 저장 
    static List<Integer> house = new ArrayList<>(); // 단지에 속하는 집의 수 저장 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 지도 & visited 배열 생성 
        map = new int[N][N];
        visited = new boolean[N][N];
        // 지도 입력
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            for(int j=0;j<N;j++)
                map[i][j] = temp.charAt(j)-'0';
        }
        // dfs 탐색 
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j])
                    dfs(i,j);
            }
        }
    
        System.out.println(house.size()); // 단지 수 출력 
        Collections.sort(house); // 단지에 속한 집의 수 정렬 
        for(int i=0;i<house.size();i++) // 단지에 속한 집의 수 출력 
            System.out.println(house.get(i));
        br.close();
    }
    
    static void dfs(int i,int j){
        int cnt = 0;
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        visited[i][j] = true;
        stack.offerLast(new int[] {i,j});
        cnt++;

        while(!stack.isEmpty()){
            int[] ij = stack.pollLast();
            i = ij[0];
            j = ij[1];

            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N && map[ni][nj]==1 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    stack.addLast(new int[] {ni,nj});
                    cnt++;
                }
            }
        }
        house.add(cnt);
    }
}
