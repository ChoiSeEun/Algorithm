import java.io.*;
import java.util.*;
public class Bj_B2_2675_문자열반복 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for(int i=0;i<S.length();i++){
                for(int j=0;j<R;j++)
                    System.out.print(S.charAt(i));
            }
            System.out.println();
        }
        br.close();
    }
}
