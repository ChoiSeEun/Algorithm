import java.util.*;
import java.io.*;
public class Swea_D3_1873_상호의배틀필드 {

    static char[][] map;
    static int ti,tj;
    static int H,W;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\SSAFY\\Algorithm\\Lecture\\res\\input_d3_1873.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for(int i=0;i<H;i++){
                String row = br.readLine();
                for(int j=0;j<W;j++){
                    map[i][j] = row.charAt(j);
                    // 전차의 초기 위치 저장 
                    if(map[i][j]=='^'||map[i][j]=='v'||map[i][j]=='<'||map[i][j]=='>'){
                        ti = i;
                        tj = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String command = br.readLine();

            for(int c=0;c<N;c++){
                char nowCommand = command.charAt(c);
                switch(nowCommand){
                    case 'U':
                        Up();
                        break;
                    case 'D':
                        Down();
                        break;
                    case 'L':  
                        Left();
                        break;
                    case 'R':
                        Right();
                        break;
                    case 'S':
                        Shoot();
                        break;
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++) sb.append(map[i][j]);
            sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
    // 범위 내에 위치하고 이동가능한지 확인하는 함수 
    static boolean isAvailable(int i,int j){
        if(0<=i&&i<H && 0<=j&&j<W && map[i][j]=='.') return true;
        return false;
    }
    static void Up(){ // 전차가 바라보는 방향을 위쪽으로 바꾸고 한 칸 위가 평지라면 이동 
        map[ti][tj] = '^';
        int ni = ti-1;
        int nj = tj;
        if(isAvailable(ni,nj)){
            map[ti][tj] = '.';
            map[ni][nj] ='^';
            ti = ni;
            tj = nj;
        }
    }
    static void Down(){ // 전차가 바라보는 방향을 아래쪽으로 바꾸고 한 칸 아래의 칸이 평지라면 이동
        map[ti][tj]='v';
        int ni = ti+1;
        int nj = tj;
        if(isAvailable(ni, nj)){
            map[ti][tj] ='.';
            map[ni][nj]='v';
            ti = ni;
            tj = nj;
        }
    }
    static void Left(){ // 전차가 바라보는 방향을 왼쪽으로 바꾸고 한 칸 왼쪽의 칸이 평지라면 이동 
        map[ti][tj]='<';
        int ni = ti;
        int nj = tj-1;
        if(isAvailable(ni, nj)){
            map[ti][tj] = '.';
            map[ni][nj] = '<';
            ti = ni;
            tj = nj;
        }
    }
    static void Right(){ // 전차가 바라보는 방향을 오른쪽으로 바꾸고 한 칸 오른쪽의 칸이 평지라면 이동 
        map[ti][tj] ='>';
        int ni = ti;
        int nj = tj+1;
        if(isAvailable(ni, nj)){
            map[ti][tj] = '.';
            map[ni][nj] = '>';
            ti = ni;
            tj = nj;
        }
    }
    static void Shoot(){ // 전차가 현재 바라보고 있는 방향으로 포탄 발사 
        switch(map[ti][tj]){
            case '^':
                for(int i=ti-1;i>=0;i--){ // 위쪽으로 발사 
                    if(map[i][tj]=='#') break;
                    if(map[i][tj]=='*'){
                        map[i][tj]='.';
                        break;
                    }
                }
                break;
            case 'v':
                for(int i=ti+1;i<H;i++){ // 아래쪽으로 발사 
                    if(map[i][tj]=='#') break;
                    if(map[i][tj]=='*'){
                        map[i][tj]='.';
                        break;
                    }
                }
                break;
            case '<':
                for(int j=tj-1;j>=0;j--){ // 왼쪽으로 발사 
                    if(map[ti][j]=='#') break;
                    if(map[ti][j]=='*'){
                        map[ti][j]='.';
                        break;
                    }
                }
                break;
            case '>':
                for(int j=tj+1;j<W;j++){ // 왼쪽으로 발사 
                    if(map[ti][j]=='#') break;
                    if(map[ti][j]=='*'){
                        map[ti][j]='.';
                        break;
                    }
                }
                break;
        }
    }
}