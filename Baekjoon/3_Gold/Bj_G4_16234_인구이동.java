import java.io.*;
import java.util.*;
public class Bj_G4_16234_인구이동 {
    static int[][] country;
    static int N,L,R;
    static boolean[][] visited;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    // 연합에 속하는 나라를 저장하기 위한 클래스 
    static class Point{
        int pi;
        int pj;
        public Point(int pi,int pj){
            this.pi = pi;
            this.pj = pj;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        country = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++)
                country[i][j] = Integer.parseInt(st.nextToken());
        }
        int moveDay=0; // 인구 이동이 일어나는 횟수
        while(true){
            int unionCnt=0; // 연합 count 
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                        unionCnt++;
                    }   
                }
            }
            // 연합의 개수가 총 나라의 개수와 동일한 경우
            // 연합이 없어서 인구이동이 일어나지 않았다는 의미이므로 break
            if(unionCnt==N*N) break;
            moveDay++;
        }
        System.out.println(moveDay);
        br.close();
    }
    // 연합을 만들고 인구수까지 조정 
    static void bfs(int i,int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int sum = 0; // 연합 내 인구수 저장 
        List<Point> union = new ArrayList<>(); // 연합에 포함되는 나라 저장 
        
        queue.offerLast(new int[]{i,j});
        visited[i][j] = true;
        sum += country[i][j];
        union.add(new Point(i,j));

        while(!queue.isEmpty()){
            int[] poll = queue.pollFirst();
            i = poll[0];
            j = poll[1];

            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                // 범위 내에 존재하고, 방문하지 않았던 나라
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]){
                    // 인구 차이 계산 
                    int diff = Math.abs(country[i][j]-country[ni][nj]);
                    // 인구 차이가 범위 내에 존재하면 연합 ok
                    if(L<=diff &&  diff<=R){
                        queue.offerLast(new int[]{ni,nj});
                        visited[ni][nj] = true;
                        sum += country[ni][nj];
                        union.add(new Point(ni,nj));
                    }
                }
            }
        }
        // 만들어진 연합의 인구수 조정
        int cnt = union.size();
        for(int u=0;u<cnt;u++){
            Point now = union.get(u);
            country[now.pi][now.pj] = sum / cnt;
        }
    }
}
