import java.util.*;
import java.io.*;

public class Bj_S5_2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[][] paper = new boolean[100][100];
        int total = 0;
        StringTokenizer st;
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine(), " ");
            int nj = Integer.parseInt(st.nextToken());
            int ni = Integer.parseInt(st.nextToken());

            for(int i=ni;i<ni+10;i++){
                for(int j=nj;j<nj+10;j++){
                    if(!paper[i][j]){
                        paper[i][j] = true;
                        total++;
                    }
                }
            }

        }
        System.out.println(total);
        br.close();
    }
}
