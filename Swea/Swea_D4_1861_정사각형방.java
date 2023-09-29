
import java.io.*;
import java.util.*;

public class Swea_D4_1861_정사각형방 {

    static int N;
    static int[][] rooms;
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("Lecture\\res\\input_d4_1861.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){

            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];
            int maxCnt = 0;
            int maxRoom = N*N;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++)
                    rooms[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    int cnt = dfs(i,j);
                    if(cnt>maxCnt || (cnt==maxCnt && rooms[i][j]<maxRoom)){
                        maxCnt = cnt;
                        maxRoom = rooms[i][j];
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(maxRoom).append(" ").append(maxCnt).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static int dfs(int i,int j){
        int cnt=0;
        int now = rooms[i][j];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        
        stack.offerLast(new int[] {i,j});
        cnt++;

        while(!stack.isEmpty()){
            int [] ij = stack.pollLast();
            i = ij[0];
            j = ij[1];
            now = rooms[i][j];
            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(ni>=0&&ni<N && nj>=0&&nj<N && rooms[ni][nj]==now+1){
                    stack.offerLast(new int[] {ni,nj});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
