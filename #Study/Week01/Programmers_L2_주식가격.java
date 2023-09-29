package ssafy.study.Week01;

import java.io.*;
import java.util.*;

public class Programmers_L2_주식가격 {

	public static void main(String[] args) throws Exception{
		int[] input = new int[] {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(input)));
	}

	public static int[] solution(int[] prices) throws Exception {
        int[] times = new int[prices.length];
        
        for (int i=0;i<prices.length;i++) {
        	int cnt = 0;
        	for (int j=i+1;j<prices.length;j++) {
        		cnt ++;
        		if (prices[j]<prices[i]) break;
        	}
        	times[i] = cnt;
        }
        return times;
    }
}
