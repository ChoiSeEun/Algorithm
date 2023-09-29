package ssafy.study.Week08;

import java.io.*;
import java.util.*;

public class Bj_S2_2805_나무자르기 {
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Integer[] trees = new Integer[(int)N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            trees[i] = Integer.parseInt(st.nextToken());
        // 이분탐색을 위한 정렬 
        Arrays.sort(trees,Comparator.reverseOrder());
        
        // 절단기 높이는 0부터 나무의 최대값까지 가능 
        long start = 0;
        long end = trees[0];
        long height = 0; 

        // 이분탐색
        while(start<=end){
            long nowTree = 0; // 현재 높이로 얻을 수 있는 나무
            long mid = (start+end)/2;

            for(int i=0;i<N;i++){
                if(trees[i]>mid) nowTree += (trees[i]-mid);
            }
            // 나무가 더 필요한 경우 더 자르기
            if(nowTree<M) end = mid-1;
            // 나무의 양이 충분하다면 덜 잘라보기
            else{
                height = mid;
                start = mid+1;
            }
        }
        System.out.println(height);
        br.close();
    }
}
