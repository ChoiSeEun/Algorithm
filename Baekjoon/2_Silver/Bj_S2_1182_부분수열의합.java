import java.io.*;
import java.util.*;
public class Bj_S2_1182_부분수열의합 {
    
    static int N,S;
    static int[] nums;
    static int count=0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());  
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());

        subset(0);
        if(S==0) count--; // 공집합 경우의 수를 제거
        
        System.out.println(count);
        br.close();
    }
    static void subset(int depth){
        // 부분집합이 완성되었다면 합을 계산 
        if(depth==N){
            int sum = 0;
            for(int i=0;i<N;i++){ 
                if(visited[i])
                    sum += nums[i];
            }
            if (sum==S) // 원하는 합과 같다면
                count++;
            return;
        }
        visited[depth] = true;
        subset(depth+1);
        visited[depth] = false;
        subset(depth+1);
    }
}
