import java.io.*;
import java.util.*;
public class Bj_B1_1157_단어공부 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toLowerCase();
        
        int count[] = new int[26];
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            count[c-97]++;
        }

        int max=0;
        int maxIdx=-1;
        for(int i=0;i<count.length;i++){
            if(count[i]>max) {
                max = count[i];
                maxIdx = i;
            }
        }
        int maxCnt=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==max){
                maxCnt++;
                if(maxCnt>1) break;
            }
        }
        if(maxCnt>1) System.out.println("?");
        else System.out.println(Character.toUpperCase((char)(97+maxIdx)));
        br.close();
    }
}
