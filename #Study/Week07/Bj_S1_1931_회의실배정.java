package ssafy.study.Week07;

import java.io.*;
import java.util.*;

public class Bj_S1_1931_회의실배정 {
    // 회의 클래스 
    static class conference implements Comparable<conference>{
        int start,end;
        public conference(int start,int end){
            this.start = start;
            this.end = end;
        }
        // 종료 시간을 기준으로 오름 차순 정렬 
        // 종료 시간이 동일한 경우 시작 시간 기준 오름 차순 정렬 
        @Override
        public int compareTo(conference o) {
            if(this.end==o.end) return Integer.compare(this.start,o.start);
            return Integer.compare(this.end, o.end);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        // 회의 시간 입력 받기 
        PriorityQueue<conference> conferenceList = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            conferenceList.offer(new conference(start, end));
        }
        // 가장 빨리 종료되는 회의부터 시작
        int nowEnd = conferenceList.poll().end;
        int count = 1;
        while(!conferenceList.isEmpty()){
            conference now = conferenceList.poll();
            // System.out.println(now.start);
            // 선택된 회의의 종료 시간 이후에 시작된다면 회의 가능 
            if(now.start>=nowEnd){
                nowEnd = now.end;
                count++;
            }
        }
        System.out.println(count);
        br.close();
        
    }
}
