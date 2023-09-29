package ssafy.study.Week04;

import java.io.*;
import java.util.*;

public class Prgrammers_L2_게임맵최단거리 {

    public static void main(String[] args) {
        int answer = solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println(answer);
    }
    public static int solution(int[][] maps) {
        int answer = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        int N = maps.length;
        int M = maps[0].length;
    
        queue.offerLast(new int[] {0,0});
        maps[0][0] = 1;
        while(!queue.isEmpty()){
            int[] ij = queue.pollFirst();
            int i = ij[0];
            int j = ij[1];
            for(int d=0;d<4;d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0<=ni&&ni<N&& 0<=nj&&nj<M && maps[ni][nj]==1){
                    queue.offerLast(new int[] {ni,nj});
                    maps[ni][nj] = maps[i][j]+1;
                }
            }
        }
    
        answer =(maps[N-1][M-1]>1)?maps[N-1][M-1]:-1;
        return answer;
    }
}
