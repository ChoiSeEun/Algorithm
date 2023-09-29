import java.io.*;
import java.util.*;
public class Bj_B5_10807_개수세기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
            int V = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<N;i++){
            if (arr[i]==V) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
