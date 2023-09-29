package ssafy.study.Week03;

import java.util.*;
import java.io.*;

public class Programmers_L2_캐시 {
	
    static LinkedList<String> queue;
    public static int solution(int cacheSize, String[] cities) {
        queue = new LinkedList<>();
        int time = 0;
        
        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toLowerCase();
            if(search(city)) time += 1;
            else time += 5;
            
            queue.add(city);
            
            if (queue.size() > cacheSize) {
                queue.remove(0);
            }
        }
        
        return time;
    }
    private static boolean search(String city) {
        for(int i=0;i<queue.size();i++) {
            if(queue.get(i).equals(city)) {
                queue.remove(i);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        int answer = solution(1,new String[] {"Jeju","jeju"});
        System.out.println(answer);
    }
}
