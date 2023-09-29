import java.io.*;
import java.util.*;
public class Bj_S1_1074_Z {
    static int r,c;
    static int count=0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        
        spaceSearch(0,0,(int)Math.pow(2,N));
        System.out.println(count);
        sc.close();
    }
    static void spaceSearch(int starti,int startj,int size){
        // 2*2 배열이면 z 탐색
        // 함수가 호출되었다는 것은 해당 범위에 찾고자 하는 값이 있는 것
        // z 탐색만 하면 됨 
        if(size==2){
            if(starti==r){
                if(startj==c) return;
                else{
                    count+=1;
                    return;
                }
            }
            else{
                if(startj==c){
                    count += 2;
                    return;
                }
                else{
                    count +=3;
                    return;
                }
            }
        }
        else{ // 찾고자 하는 값 위치에 따라 탐색 범위 지정
            int half = size/2;
            if(starti<=r&&r<starti+half){
                if(startj<=c&&c<startj+half){
                    spaceSearch(starti, startj, half);
                }
                else{
                    count += (half*half);
                    spaceSearch(starti, startj+half, half);
                }
            }else{
                if(startj<=c&&c<startj+half){
                    count += (half*half*2);
                    spaceSearch(starti+half, startj, half);
                }
                else{
                    count += (half*half*3);
                    spaceSearch(starti+half, startj+half, half);
                }
            }
        }
    }
}
