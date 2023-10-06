import java.io.*;
import java.util.*;
public class Bj_S1_11403_경로찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int [N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(graph[i][k]==1 && graph[k][j]==1)
                        graph[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(j!=1) sb.append(" ");
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
