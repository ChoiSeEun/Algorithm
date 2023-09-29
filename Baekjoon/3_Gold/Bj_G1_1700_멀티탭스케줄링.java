import java.io.*;
import java.util.*;
public class Bj_G1_1700_멀티탭스케줄링 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] use = new int[K];
        int[] next = new int[K];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++){
            use[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<K;i++){
            int n = K;
            for(int j=i+1;j<K;j++){
                if(use[i]==use[j]){
                    n = j;
                    break;
                }
            }
            next[i] = n;
        }
        PriorityQueue<Electronic> queue = new PriorityQueue<>();
        ArrayDeque<Integer> nowMultiTap = new ArrayDeque<>();
        ArrayDeque<Electronic> temp = new ArrayDeque<>();
        int unflug = 0;
        for(int i=0;i<K;i++){
            // 해당 기기가 이미 멀티탭을 사용 중인 경우 next 갱신
            if(nowMultiTap.contains(use[i])){
                temp.clear();
                // 해당 기기를 찾을 때까지 임시 배열에 저장 후 찾으면 다시 queue에 넣기
                while(!queue.isEmpty()){
                    Electronic t = queue.poll();
                    if(t.name==use[i]){
                        while(!temp.isEmpty()){
                            queue.offer(temp.poll());
                        }
                        break;
                    }
                    temp.offer(t);
                }
                queue.offer(new Electronic(use[i],next[i]));
            }
            // 해당 기기가 멀티탭을 사용하지 않는 경우
            else{
                // 자리가 없다면 빼고
                if(queue.size()>=N){
                    Electronic un = queue.poll();
                    nowMultiTap.remove(un.name);
                    unflug++;
                }
                // 해당 기기 추가하기
                queue.offer(new Electronic(use[i],next[i]));
                nowMultiTap.offer(use[i]);
            }
        }
        System.out.println(unflug);
        br.close();

    }
    static class Electronic implements Comparable<Electronic>{
        int name;
        int next;
        public Electronic(int name,int next){
            this.name = name;
            this.next = next;
        }

        @Override
        public int compareTo(Electronic o) {
            return -Integer.compare(this.next,o.next);
        }

    }
}
