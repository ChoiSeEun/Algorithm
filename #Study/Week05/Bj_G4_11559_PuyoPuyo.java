package ssafy.study.Week05;

import java.io.*;
import java.util.*;

public class Bj_G4_11559_PuyoPuyo {

	 // 필드 저장
    static char[][] field = new char[12][6];
    // 연쇄가 일어날 위치 저장
    static ArrayDeque<int[]> chainList = new ArrayDeque<>(); 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필드 입력 받기 
        for(int i=0;i<12;i++){
            String row = br.readLine();
            for(int j=0;j<6;j++)
                field[i][j] = row.charAt(j);
        }
        // 연쇄 수행 횟수
        int count = 0;
        // 첫 번째 연쇄가 가능한지 확인 
        checkChain(new boolean[12][6]); 
        while(true){
            if(!chainList.isEmpty()) { // 연쇄가 일어날 위치가 있다면 연쇄 진행 
                chain(); // 연쇄 수행 
                count++; // 연쇄 수행 횟수 count
                gravity(); // 연쇄 후 떨어지기 
                checkChain(new boolean[12][6]); // 다음 연쇄 가능 여부 확인 
            } 
            // 연쇄가 일어날 위치가 없는 경우 종료 
            else break;
        }
        // 연쇄 수행 횟수 출력 
        System.out.println(count);
        br.close();
    }
    // 연쇄가 일어날 수 있는 뿌요를 판단 
    // 판단은 bfs로 , 연쇄는 동시 발생되므로 한 번에 저장해서 연쇄 수행 (chain 함수)
    static void checkChain(boolean[][] visited){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){ // 방문하지 않은 뿌요인 경우 bfs 탐색 
                if(field[i][j]!='.' && !visited[i][j]) bfs(i,j,visited);
            }
        }
    }
    // 연쇄가 일어날 수 있는 조건을 만족하는지 판단 = 같은 색 뿌요가 4개 이상 상하좌우로 연결
    static void bfs(int i,int j,boolean[][] visited){
        // bfs 큐
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 탐색한 뿌요의 위치를 저장할 임시 큐 
        ArrayDeque<int[]> tmp = new ArrayDeque<>(); 

        // 상하좌우 탐색 
        int [] di = {-1,1,0,0};
        int [] dj = {0,0,-1,1};
        
        // 탐색하고 있는 뿌요의 색깔을 저장 
        char color = field[i][j];

        queue.offer(new int[]{i,j});
        visited[i][j] = true; 
        int cnt = 1;  // 같은 색의 뿌요 카운트
        tmp.offer(new int[]{i,j}); // 4개 이상이 같은 색일 경우를 위한 임시 저장 

        // 연결되어 있는 같은 색의 뿌요들을 탐색
        while(!queue.isEmpty()){
            int [] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0<=ni&&ni<12 && 0<=nj&&nj<6 && !visited[ni][nj] && field[ni][nj]==color){
                    queue.offer(new int[] {ni,nj});
                    visited[ni][nj] = true;
                    cnt ++;
                    tmp.offer(new int[]{ni,nj});
                }
            }
        }
        // 같은 색의 뿌요가 4개 이상인 경우 연쇄가 일어날 수 있는 조건을 만족 
        if(cnt>=4){
            // 저장해뒀던 위치가 모두 연쇄가 발생할 위치 
            // 연쇄 수행을 위해 chainList 큐에 추가 
            while(!tmp.isEmpty()){  
                int[] poll = tmp.poll();
                chainList.offer(poll);
            }
        }
        else return;
    }
    // 연쇄 수행
    static void chain(){
        // 저장하고 있는 모든 위치에 대해서 연쇄 수행 
        while(!chainList.isEmpty()){ 
            int[] poll = chainList.poll();
            int i = poll[0];
            int j = poll[1];
            field[i][j] = '.'; // 연쇄가 발생한 뿌요는 빈 공간으로 삭제
        }
    }
    // 중력의 영향을 받아 떨어지는 뿌요
    static void gravity(){
        // 맨 마지막 줄은 뿌요가 있어도 떨어질 수 있는 위치가 없으므로 생략 
        // 뒤에서 두번째 줄부터 떨어지기 
        // 그래야 모든 뿌요가 끝까지 떨어질 수 있음 
        for(int i=10;i>=0;i--){ 
            for(int j=0;j<6;j++){
                // 모든 뿌요는 중력을 받음
                if(field[i][j]!='.') down(i,j);
            }
        }
    }
    // 중력으로 떨어지기 
    static void down(int pi,int pj){
        // 현재 뿌요를 저장 
        char puyo = field[pi][pj];
        // 한 칸 아래부터 시작 
        int i = pi+1;

        // 내려갈 수 있을 때까지 한 칸씩 내려가기
        while(i<=11 && field[i][pj]=='.'){ 
            field[i][pj] = puyo;
            field[i-1][pj] = '.';
            ++i;
        }
    }

}
