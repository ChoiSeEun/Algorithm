import java.io.*;
import java.util.*;
public class Swea_D3_10580_전봇대 {
    static class wire{
        int A;
        int B;
        public wire(int A,int B){
            this.A = A;
            this.B = B;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            wire[] wires = new wire[N];
            // 전선 입력 받기 
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                wires[i] = new wire(A,B);
            }
            int cross = 0;
            // 앞 기준으로 정렬 
            Arrays.sort(wires,(o1,o2)-> Integer.compare(o1.A,o2.A));
            for(int i=0;i<N;i++){
                for (int j=i+1;j<N;j++){
                    if (wires[i].B>wires[j].B) cross++;
                }
            }

            sb.append("#").append(tc).append(" ")
                .append(cross).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    
}