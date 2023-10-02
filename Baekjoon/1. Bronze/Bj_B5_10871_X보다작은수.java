import java.io.*;
import java.util.*;

public class Bj_B5_10871_X보다작은수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());
            if(now<X) System.out.print(now+" ");
        }
    }
}
