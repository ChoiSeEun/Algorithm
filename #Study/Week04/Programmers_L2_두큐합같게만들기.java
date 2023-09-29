package ssafy.study.Week04;

import java.io.*;
import java.util.*;

public class Programmers_L2_두큐합같게만들기 {

    public static void main(String[] args) throws Exception{
        System.out.println(solution(new int[]{101,100},new int[]{102,103}));
    }


    public static int solution(int[] queue1,int[] queue2){
        int cnt=0;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();

        long sum1=0,sum2=0;
        for(int i=0;i<queue1.length;i++){
            q1.offerLast(queue1[i]);
            sum1 += queue1[i];

            q2.offerLast(queue2[i]);
            sum2 += queue2[i];
        }
        long target = (sum1+sum2)/2;
            
        while(true){
            // 두 큐의 합이 같아진 경우 
            if(sum1==target && sum2==target) return cnt;
            // 두 큐의 합을 같게 만들 수 없는 경우 
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(cnt>(queue1.length+queue2.length)*2) return -1;
            
            cnt ++;
            if(sum1>target){
                sum1 -= q1.peekFirst();
                sum2 += q1.peekFirst();
                q2.offerLast(q1.pollFirst());
            }
            else{
                sum1 += q2.peekFirst();
                sum2 -= q2.peekFirst();
                q1.offerLast(q2.pollFirst());
            }
        }
    }
}


