import java.io.*;
import java.util.*;

public class Bj_G5_1759_암호만들기 {
    static int L,C;
    static char[] array;
    static char[] candidate;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[C];
        candidate = new char[L];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++)
            array[i] = st.nextToken().charAt(0);

        Arrays.sort(array);
        combination(0,0);
        br.close();
    }
    static void combination(int depth,int start){
        if(depth==L){
            int conCnt=0;
            int vowCnt=0;
            // 모음, 자음 갯수 확인 
            for(int i=0;i<candidate.length;i++){
                if(candidate[i]=='a' || candidate[i]=='e' || candidate[i]=='i' || candidate[i]=='o' || candidate[i]=='u')
                    vowCnt ++;
                else 
                    conCnt ++;
            }
            // 정렬
            if(vowCnt>=1 && conCnt>=2){
                Arrays.sort(candidate);
                for(int i=0;i<candidate.length;i++)
                    System.out.print(candidate[i]);
                System.out.println();
            }
            return;
        }
        for(int i=start;i<C;i++){
            candidate[depth] = array[i];
            combination(depth+1,i+1);
        }
    }
}
