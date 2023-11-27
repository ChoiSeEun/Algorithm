import java.io.*;
import java.util.*;
public class Bj_S4_10816_숫자카드2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[20_000_001];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            numbers[num+10_000_000]++;
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(numbers[num+10_000_000]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
