import java.io.*;
import java.util.*;
public class Programmers_Solution_l2_줄서는방법 {
    public static void main(String[] args) throws Exception{
        int[] answer = solution(3,5);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(int n,long k){
        int[] arr = new int[n];
        for(int i=0;i<n;i++) // arr은 정렬된 상태
            arr[i] = i+1;
        // next permutation 
        for(int i=0;i<k-1;i++)
            nextPermutation(arr);

        return arr;
        
    }
    public static boolean nextPermutation(int[] arr){
        int N = arr.length;
        int i = N-1;
        
        while(i>0 && arr[i-1]>=arr[i]) --i;

        if(i==0) return false;

        int j = N-1;
        while(arr[i-1]>=arr[j]) --j;
        swap(arr,i-1,j);

        int k = N-1;
        while(i<k)
            swap(arr,i++,k--);
        return true;        
    }   
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
