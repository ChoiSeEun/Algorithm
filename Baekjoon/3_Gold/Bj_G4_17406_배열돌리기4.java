import java.io.*;
import java.util.*;

public class Bj_G4_17406_배열돌리기4 {

    static int N,M,K;
    static int[][] array,array_temp; //array : 원본 배열 array_temp : 연산 적용 
    static int[] calorder; // 연산순서순열
    static boolean[] visited; // for 순열 생상
    static calculation[] calArray; // 연산 저장 
    static int minVal=Integer.MAX_VALUE; // 배열의 최솟값 저장 

    static class calculation{
        int r;
        int c;
        int s;
        public calculation(int r,int c,int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 입력 받기 
        array = new int[N][M];
        array_temp = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }
        // 연산 입력 받기 
        calArray = new calculation[K];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            calArray[i] = new calculation(r, c, s);
        }
        // 연산 순서 순열 생성
        // 순열 배열 하나씩 생성 후 바로 배열 값 계산 
        calorder = new int[K];
        visited = new boolean[K];
        copy(); // 처음 입력받은 배열에서 시작하도록 
        permutation(0);
        System.out.println(minVal);
        br.close();
    }

    // 배열의 값 계산 
    static int arrayValue(){
        int value = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<M;j++)
                sum += array_temp[i][j];
            if (sum<value) value = sum;
        }
        return value;
    }
    // 배열 회전
    static void rotate(calculation cal){

        int [] start = new int[]{cal.r-cal.s-1,cal.c-cal.s-1};
        int [] end = new int[]{cal.r+cal.s-1,cal.c+cal.s-1};

        int N = end[0]-start[0]+1;
        int M = end[1]-start[1]+1;

        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};
        int count = Math.min(N, M)/2;

        for(int c=0;c<count;c++){
            int i = start[0]+c;
            int j = start[1]+c;
            int temp = array_temp[i][j];
            int d =0;
            while(d<4){
                int ni = i + di[d];
                int nj = j + dj[d];

                if(start[0]+c<=ni&&ni<start[0]+N-c && start[1]+c<=nj&&nj<start[1]+M-c){
                    array_temp[i][j] = array_temp[ni][nj];
                    // for(int[] t:array_temp) System.out.println(Arrays.toString(t));
                    // System.out.println();
                    i = ni;
                    j = nj;
                }else d++;
            }
            array_temp[start[0]+c][start[1]+c+1] = temp;
        }
        // for(int[] t:array_temp) System.out.println(Arrays.toString(t));
    }
    // 연산 순서 순열 생성
    static void permutation(int cnt){
        if(cnt==K){ // 순열 생성 완료
            // 생성한 순열에 따라 연산 
            for(int i=0;i<K;i++)
                rotate(calArray[calorder[i]]);
            // 배열 값 계산 
            int val = arrayValue();
            // 배열 값 업데이트 
            if(val<minVal) minVal = val;
            // array_temp 원본 배열화
            copy();
            return;
        }
        for(int i=0;i<K;i++){
            if(visited[i]) continue;
            visited[i] = true;
            calorder[cnt] = i;
            permutation(cnt+1);
            visited[i] = false;
        }
    }
    static void copy(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                array_temp[i][j] = array[i][j];
        }
    }
}
