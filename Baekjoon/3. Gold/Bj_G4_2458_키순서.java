import java.io.*;
import java.util.*;
public class Bj_G4_2458_키순서 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] connection = new boolean[N][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            connection[a][b] = true;
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(connection[i][k] && connection[k][j])
                        connection[i][j] = true;
                }
            }
        }
        int[] cnt = new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(connection[i][j]||connection[j][i])
                    cnt[i] ++;
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            if(cnt[i]==N-1) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}
