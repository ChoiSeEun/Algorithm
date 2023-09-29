package ssafy.study.Week05;

import java.io.*;
import java.util.*;

public class Programmers_L2_타겟넘버 {

    public static void main(String[] args) throws Exception{
        int answer = solution(new int[]{1,1,1,1,1},3);
        System.out.println(answer);
    }
    static int solution(int[] numbers,int target){
        int answer = dfs(numbers,0,0,target);
        return answer;
    }
    static int dfs(int[] numbers,int i,int nowSum,int target){
        int res = 0;
        
        if(i==numbers.length){
            if(nowSum == target) res +=1;
        } 
        else{
            res += dfs(numbers,i+1,nowSum+numbers[i],target);
            res += dfs(numbers,i+1,nowSum-numbers[i],target);
        }
        return res;
    }
}
