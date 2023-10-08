import java.io.*;
import java.util.*;
public class Bj_P5_1786_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int tLength = T.length;
        int pLength = P.length;
        // Pi 배열 만들기
        int[] pi = new int[pLength];
        int j=0;
        for(int i=1;i<pLength;i++){
            while(j>0 && P[i]!=P[j]){
                j = pi[j-1];
            }
            if(P[i]==P[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        // 문자열 찾기
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        j=0;
        for(int i=0;i<tLength;i++){
            while(j>0 && T[i]!=P[j]) j = pi[j-1];

            if(T[i]==P[j]){
                if(j==pLength-1){
                    cnt++;
                    list.add(i-j+1);
                    j = pi[j];
                }
                else j++;
            }
        }
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        for(int l=0;l<list.size();l++){
            sb.append(list.get(l));
            if(l!=list.size()-1) sb.append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
