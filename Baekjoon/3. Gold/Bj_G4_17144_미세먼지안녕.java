import java.io.*;
import java.util.*;
public class Bj_G4_17144_미세먼지안녕 {
    
    static int[][]rooms;
    static int R,C;
    static int[]airCleaner = new int[2];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        rooms = new int [R][C];
        int a = 0;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<C;j++){
                rooms[i][j] = Integer.parseInt(st.nextToken());
                // 공기청정기 위치 저장 
                if(rooms[i][j]==-1) {
                    airCleaner[a++] = i;
                }
            }
        }
        for(int t=0;t<T;t++){
            spread();
            airClean();
        }
        int total = 2; // 공기청정기 -2 되는 값을 상쇄
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) total += rooms[i][j];
        }
        System.out.println(total);
        br.close();
    }
    static void spread(){
        // 상하좌우 
        int [] di = {-1,1,0,0};
        int [] dj = {0,0,-1,1};
        int[][] plus = new int[R][C]; // 확산되는 먼지의 값 저장 
        // 확산될 먼지 계산 
        for(int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if(rooms[i][j]>0){ // 확산될 먼지가 있는 경우 
                    int d = 0;
                    int cnt = 0; // 확산이 일어난 방향 count 
                    while(d<4){
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if(0<=ni&&ni<R && 0<=nj&&nj<C && rooms[ni][nj]!=-1){
                            cnt ++;
                            plus[ni][nj] += rooms[i][j]/5;
                        }d++;
                    }
                    rooms[i][j] -= (rooms[i][j]/5)*cnt;
                }
            }
        }
        // 합산
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++)
                rooms[i][j] += plus[i][j];
        }
    }
    static void airClean(){
        // 위 쪽은 반시계방향 순환
        int i = airCleaner[0];
        int j = 0;
        
        int [] di = {-1,0,1,0};
        int [] dj = {0,1,0,-1};

        int d=0;
        while(d<4){
            int ni = i + di[d];
            int nj = j + dj[d];
            // 범위내에 존재하면 
            if(0<=ni&&ni<=airCleaner[0] && 0<=nj&&nj<C){
                if(rooms[ni][nj]==-1) rooms[i][j] = 0; // 공기청정기에 들어간 먼지 정화 
                else if(rooms[i][j]!=-1) rooms[i][j] = rooms[ni][nj];
                i = ni;
                j = nj;
            }else d++;
        }

        // 아래 쪽은 시계방향 순환 
        i = airCleaner[1];
        j = 0;

        di = new int[]{1,0,-1,0};
        dj = new int[]{0,1,0,-1};

        d = 0;
        while(d<4){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(airCleaner[1]<=ni&&ni<R && 0<=nj&&nj<C){
                if(rooms[ni][nj]==-1) rooms[i][j] = 0; // 공기청정기에 들어간 먼지 정화
                else if(rooms[i][j]!=-1) rooms[i][j] = rooms[ni][nj];
                i = ni;
                j = nj;
            } else d++;
        }
    }
}

