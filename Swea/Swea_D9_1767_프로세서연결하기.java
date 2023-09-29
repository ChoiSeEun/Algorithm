import java.io.*;
import java.util.*;
public class Swea_D9_1767_프로세서연결하기 {
    static int[][] maxinos;
    static int N,maxCnt,shortLength;
    static List<int[]> coreList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            maxinos = new int[N][N];
            coreList = new ArrayList<>();
            maxCnt = 0;
            shortLength = Integer.MAX_VALUE;

            // 멕시노스 정보 입력받기 
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    maxinos[i][j] = Integer.parseInt(st.nextToken());
                    // 코어가 입력되었다면 
                    if(maxinos[i][j]==1){
                        // 가장자리에 입력된 코어는 무시 
                        if(i==0||i==N-1|| j==0||j==N-1) continue;
                        // 가장자리가 아니라면 리스트에 추가 
                        coreList.add(new int[]{i,j});
                    }
                }
            }
            backtracking(0,0,0);
            sb.append("#").append(tc).append(" ").append(shortLength).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void backtracking(int idx,int cnt,int length){
        // System.out.println("현재 코어 번호 : "+idx+" 현재 length: "+length);
        // 값 갱신
        if(cnt>maxCnt){
            maxCnt = cnt;
            shortLength = length;
        }
        else if(cnt==maxCnt && length<shortLength){
            shortLength = length;
        }
        // 모든 코어에 대한 고려가 끝났다면 종료 
        if(idx==coreList.size()) return;

        // 현재 코어에 대해 4방향 + 선택안함 경우 고려하기
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        int ci = coreList.get(idx)[0];
        int cj = coreList.get(idx)[1];

        for(int d=0;d<4;d++){
            int newLine = contact(ci,cj,di[d],dj[d]);
            if(newLine>0){ // 코어 연결이 가능한 경우 
                backtracking(idx+1, cnt+1, length+newLine);
                rollback(ci,cj,di[d],dj[d]);
            }    
        }
        // 해당 코어를 연결하지 않는 경우 
        backtracking(idx+1,cnt,length);
    }

    // ci,cj : 코어의 위치 
    // di,dj : 전선을 연결할 방향 
    // 해당 위치에서 연결할 수 있는 전선의 길이 return 
    // 가능한 전선은 연결하고, 중간에 아니라고 판단되면 다시 복구 
    static int contact(int ci,int cj,int di,int dj){
        List<int[]> backList = new ArrayList<>();
        int len = 0;

        while(true){
            int ni = ci + di;
            int nj = cj + dj;
            // 전선을 연결할 수 있는 위치라면 
            if(0<=ni&&ni<N && 0<=nj&&nj<N && Math.abs(maxinos[ni][nj])!=1){
                // 전선 연결 완료 
                if(ni==0 || ni==N-1 || nj==0 || nj==N-1) return len+1;
                // 전선 연결 
                backList.add(new int[]{ni,nj});
                maxinos[ni][nj] = -1;
                len++;
                ci = ni;
                cj = nj;
            }
            // 전선을 연결할 수 없다면 원상복귀 
            else{ 
                for(int i=0;i<backList.size();i++){
                    int bi = backList.get(i)[0];
                    int bj = backList.get(i)[1];
                    maxinos[bi][bj] = 0;
                }
                return 0;
            }
        }
    }
    // 연결이 완료된 전선을 다시 되돌리기 
    static void rollback(int ci,int cj,int di,int dj){
        while(true){
            int ni = ci + di;
            int nj = cj + dj;
            if(0<=ni&&ni<N && 0<=nj&&nj<N){
                maxinos[ni][nj] = 0;
                ci = ni;
                cj = nj;
            }
            else break;
        }
    }
}
