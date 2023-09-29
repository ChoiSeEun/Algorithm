import java.io.*;
import java.util.*;
public class Swea_D4_1238_Contact {
    static boolean[] visited = new boolean[101];
    static List<Integer>[] adjList = new List[101];
    static class Person{
        int num;
        int depth;
        public Person(int num,int depth){
            this.num = num;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\SSAFY\\Algorithm\\2. Lecture\\res\\input_d4_1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=100;i++) adjList[i] = new ArrayList<>();

        for(int tc=1;tc<=10;tc++){
            st = new StringTokenizer(br.readLine()," ");
            int LENGTH = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            // 인접리스트 초기화 
            for(int i=1;i<=100;i++) adjList[i].clear();
            // 방문 여부 배열 초기화 
            Arrays.fill(visited, false);
            // 값 입력받아서 인접리스트에 저장하기 
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<LENGTH/2;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from].add(to);
            }
            int max = bfs(start);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    static int bfs(int i){
        ArrayDeque<Person> queue = new ArrayDeque<>(); // for BFS
        ArrayDeque<Person> person = new ArrayDeque<>(); // 같은 높이로 연락받은 사람 저장
        visited[i] = true;
        queue.offer(new Person(i, 0));
        int depth = 0;

        while(!queue.isEmpty()){
            Person now = queue.poll();
            depth = now.depth;
            for(int j:adjList[now.num]){
                if(!visited[j]){
                    visited[j] = true;
                    queue.offer(new Person(j, depth+1));
                    person.offer(new Person(j, depth+1));
                }
            }
        }
        int max = 0;
        while(!person.isEmpty()){
            Person now = person.poll();
            if(now.depth==depth && now.num>max) max = now.num;
        }
        return max;
    }
}
