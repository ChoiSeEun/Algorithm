package ssafy.study.Week07;

import java.io.*;
import java.util.*;

public class Bj_G5_11000_강의실배정 {

    static class Lecture implements Comparable<Lecture>{
        int start,end;
        public Lecture(int start,int end){
            this.start = start;
            this.end = end;
        }
		@Override
		public int compareTo(Lecture o) {
			if(this.start==o.start) return Integer.compare(this.end,o.end);
			return Integer.compare(this.start, o.start);
		}
        
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Lecture[] lecturelist = new Lecture[N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	lecturelist[i] = new Lecture(start,end);
        }
        Arrays.sort(lecturelist);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(lecturelist[0].end);
        
        for(int i=1;i<N;i++) {
        	if(lecturelist[i].start>=queue.peek()) 
        		queue.poll();
        	queue.offer(lecturelist[i].end);
        }
        System.out.println(queue.size());
        br.close();
    }
    
}
