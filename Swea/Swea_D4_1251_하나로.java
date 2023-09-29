import java.io.*;
import java.util.*;
public class Swea_D4_1251_하나로 {
    static double[][] adjMatrix;
    static boolean[] visited;
    static double[] minEdge;
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\SSAFY\\Algorithm\\2. Lecture\\res\\input_d4_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            adjMatrix = new double[N][N];
            visited = new boolean[N];
            minEdge = new double[N];

            int[] tempX = new int[N];
            int[] tempY = new int[N];
            // x좌표 입력받기 
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)
            tempX[i] = Integer.parseInt(st.nextToken());
            // y좌표 입력받기
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                tempY[i] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());
            // 좌표 간 거리 계산 
            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    double dist = dist(tempX[i],tempY[i],tempX[j],tempY[j]);
                    adjMatrix[i][j] = adjMatrix[j][i] = dist*E;
                }
            }
            // for(int i=0;i<adjMatrix.length;i++) System.out.println(Arrays.toString(adjMatrix[i]));
            Arrays.fill(minEdge,Double.MAX_VALUE);
            // 최소 환경 부담금 
            double result = 0;
            int cnt = 0; 

            minEdge[0] = 0; // 임의 정점 최소 처리
            
            for(int i=0;i<N;i++){
                int minVertex = -1;
                double min = Double.MAX_VALUE;

                for(int j=0;j<N;j++){
                    if(!visited[j]&&min>minEdge[j]){
                        minVertex = j;
                        min = minEdge[j];
                    }
                }

                visited[minVertex] = true;
                result += min;

                if(cnt++==N-1) break;

                for(int j=0;j<N;j++){
                    if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j]>adjMatrix[minVertex][j]){
                        minEdge[j] = adjMatrix[minVertex][j];
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(String.format("%.0f", result)).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static double dist(int x1,int y1,int x2,int y2){
        return (double)(Math.pow((x2-x1),2))+(double)(Math.pow((y2-y1),2));
    }
}
