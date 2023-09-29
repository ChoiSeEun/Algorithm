import java.io.*;
import java.util.*;

public class Swea_D3_9229_한빈이와SpotMart {

    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("res/input_d3_9229.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int [] snak = new int [N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)
                snak[i] = Integer.parseInt(st.nextToken());
            
            // 정렬해서 deque에 추가 
            Arrays.sort(snak);
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(int i=0;i<N;i++)
                deque.offer(snak[i]);
            
            // 가장 최댓값과 최솟값 확인 
            int max_sum = -1;
            int max = deque.pollLast();
            int min = deque.pollFirst();
            
            while(!deque.isEmpty()) {
                if (max+min>M) // 결과가 M보다 크다면 
                    max = deque.pollLast(); // 최댓값 변경
                else { // 결과가 M 이하라면
                    max_sum = Math.max(max_sum,max+min); // max_sum 업데이트 후 
                    min = deque.pollFirst(); // 최소값 변경 
                }
            }
            // 마지막 경우 최종 확인 
            if(max+min<=M) max_sum = Math.max(max_sum,max+min);
            sb.append("#").append(tc).append(" ").append(max_sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}