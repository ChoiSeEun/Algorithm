import java.io.*;
import java.util.*;

public class CodeTree_포탑부수기 {

    static int N,M;
    static int[][] map;
    static int[][] lastAttack;
    static boolean[][] isAttacked;
    //우 하 좌 상
    static int[] di = { 0, 1, 0, -1, 1, 1, -1, -1 };
    static int[] dj = { 1, 0, -1, 0, -1, 1, -1, 1 };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        lastAttack = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1턴부터 K턴까지 진행
        for(int turn=1;turn<=K;turn++){
            // 부서지지 않은 포탑이 1개라면 즉시 중지
            if(isOneTop()) break;
            // 이전 공격 관련 여부 초기화
            isAttacked = new boolean[N][M];

            // 공격자 찾기
            int[] attacker = findWeek();
            map[attacker[0]][attacker[1]] += N+M;
            isAttacked[attacker[0]][attacker[1]] = true;
            lastAttack[attacker[0]][attacker[1]] = turn;

            // 공격대상 찾기
            int[] target  = findStrong(attacker);
            isAttacked[target[0]][target[1]] = true;

            // 공격하기
            if(!laserAttack(attacker,target)){
                shellAttack(attacker,target);
            }
            // 부서지기
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]<0) map[i][j]=0;
                }
            }
            // 정비하기
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==0) continue;
                    if(isAttacked[i][j]) continue;
                    map[i][j] += 1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                max = Math.max(max,map[i][j]);
            }
        }
        System.out.println(max);
        br.close();
    }
    // 남은 포탑이 하나인지 확인
    static boolean isOneTop(){
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0) continue;
                cnt++;
            }
        }
        return cnt==1;
    }
    // 공격자 선정해서 인덱스 값을 반환
    static int[] findWeek() {
        int power = 5001;
        int weekI = 0;
        int weekJ = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                // 부서진 탑인 경우 pass
                if(map[i][j]<=0) continue;

                // 공격력 비교
                if(power<map[i][j]) continue;
                else if(power>map[i][j]){
                    power = map[i][j];
                    weekI = i;
                    weekJ = j;
                    continue;
                }
                // 최근 공격 여부 비교
                if(lastAttack[weekI][weekJ]>lastAttack[i][j]) continue;
                else if(lastAttack[weekI][weekJ]<lastAttack[i][j]){
                    power = map[i][j];
                    weekI = i;
                    weekJ = j;
                    continue;
                }
                // 행과 열의 합 비교
                if(weekI+weekJ>i+j) continue;
                else if(weekI+weekJ<i+j){
                    power = map[i][j];
                    weekI = i;
                    weekJ = j;
                    continue;
                }
                // 열 비교
                if(j>weekJ) {
                    power = map[i][j];
                    weekI = i;
                    weekJ = j;
                }
            }
        }
        return new int[]{weekI,weekJ};

    }
    // 공격대상 선정해서 인덱스 값을 반환
    static int[] findStrong(int[] attacker) {
        int power = -1;
        int strongI = 0;
        int strongJ = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                // 부서진 탑인 경우 pass
                if(map[i][j]<=0) continue;
                // 공격자인 경우 pass
                if(i==attacker[0] && j==attacker[1]) continue;
                // 공격력 비교
                if(power>map[i][j]) continue;
                else if(power<map[i][j]){
                    power = map[i][j];
                    strongI = i;
                    strongJ = j;
                    continue;
                }
                // 최근 공격 여부 비교
                if(lastAttack[strongI][strongJ]<lastAttack[i][j]) continue;
                else if(lastAttack[strongI][strongJ]>lastAttack[i][j]){
                    power = map[i][j];
                    strongI = i;
                    strongJ = j;
                    continue;
                }
                // 행과 열의 합 비교
                if(strongI+strongJ<i+j) continue;
                else if(strongI+strongJ>i+j){
                    power = map[i][j];
                    strongI = i;
                    strongJ = j;
                    continue;
                }
                // 열 비교
                if(strongJ>j){
                    power = map[i][j];
                    strongI = i;
                    strongJ = j;
                }
            }
        }
        return new int[] {strongI,strongJ};
    }
    // 레이저 공격
    static boolean laserAttack(int[] weeker,int[] stronger) {

        ArrayDeque<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        Point[][] next = new Point[N][M];

        visited[weeker[0]][weeker[1]] = true;
        queue.offer(new Point(weeker[0],weeker[1]));

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            for(int d=0;d<4;d++){
                int ni = (poll.x+di[d]+N)%N;
                int nj = (poll.y+dj[d]+M)%M;

                if(visited[ni][nj]) continue;
                if(map[ni][nj]==0) continue;

                next[ni][nj] = new Point(poll.x,poll.y);
                visited[ni][nj] = true;
                queue.offer(new Point(ni,nj));
            }
        }
        if(!visited[stronger[0]][stronger[1]]) return false;

        int i = stronger[0];
        int j = stronger[1];
        while(i!=weeker[0] || j!=weeker[1]){
            int power = map[weeker[0]][weeker[1]]/2;
            if(i==stronger[0] && j==stronger[1]) power = map[weeker[0]][weeker[1]];
            map[i][j] -= power;
            isAttacked[i][j] = true;

            Point point = next[i][j];
            i = point.x;
            j = point.y;
        }
        return true;
    }
    // 포탄 공격
    static void shellAttack(int[] weeker,int[]stronger) {
        map[stronger[0]][stronger[1]] -= map[weeker[0]][weeker[1]];
        int attackPower = map[weeker[0]][weeker[1]]/2;

        for(int d=0;d<8;d++){
            int ni = (stronger[0]+di[d]+N)%N;
            int nj = (stronger[1]+dj[d]+M)%M;

            if(ni==weeker[0] && nj==weeker[1]) continue;
            map[ni][nj] -= attackPower;
            isAttacked[ni][nj] = true;
        }
    }

    static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}