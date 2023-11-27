import java.util.*;
import java.io.*;
public class Bj_S5_10814_나이순정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        member[] members = new member[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            members[i] = new member(Integer.parseInt(st.nextToken()),i,st.nextToken());
        }
        Arrays.sort(members);
        for(int i=0;i<N;i++){
            System.out.println(members[i]);
        }

    }
    static class member implements Comparable<member>{
        int age;
        int join;
        String name;

        public member(int age,int join,String name){
            this.age = age;
            this.join = join;
            this.name = name;
        }

        @Override
        public int compareTo(member o) {
            if(this.age==o.age) return Integer.compare(this.join,o.join);
            return Integer.compare(this.age,o.age);
        }
        @Override
        public String toString(){
            return age+" "+name;
        }
    }
}
