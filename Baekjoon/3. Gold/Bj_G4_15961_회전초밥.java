import java.io.*;
import java.util.*;
public class Bj_G4_15961_회전초밥 {
    static int[] sushi;
    static int[] eaten;
    static int cnt=0,maxCnt=0;
    static int N,k,c;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        eaten = new int[d+1];

        eaten[c] = 1; // 쿠폰 초밥은 매번 먹기 
        maxCnt++;

        for(int i=0;i<N;i++)
            sushi[i] = Integer.parseInt(br.readLine());
        // 처음 k개 먹기 
        for(int i=0;i<k;i++){
            eaten[sushi[i]] ++;
            if(eaten[sushi[i]]==1) maxCnt++;
        }
        cnt = maxCnt;
        // 그 이후 먹기
        turn();
        System.out.println(maxCnt);
        br.close();
    }
    static void turn(){
        int start = k;
        while(true){
            if (start==(N-1)+k){ // 끝까지 다 돌았다면 종료
                break;
            }
            // 이전에 먹었던 것 뱉기
            eaten[sushi[(start-k)%N]]--;
            // 그래서 먹은거에 포함되지 않았다면 
            if(eaten[sushi[(start-k)%N]]==0) cnt--;
            // 다음꺼 먹기
            eaten[sushi[start%N]]++;
            if(eaten[sushi[start%N]]==1) cnt++;

            maxCnt = Math.max(maxCnt, cnt);
            start++;
        }
    }
}