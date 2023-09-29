import java.io.*;
import java.util.*;

public class Swea_D3_1289_원재의메모리복구하기 {

	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	         
	        StringBuilder sb = new StringBuilder();
	        for(int tc=0;tc<T;tc++) {
	            char[] bit = br.readLine().toCharArray();
	            int len = bit.length;
	            char nowbit = '0';
	            int ans = 0;
	             
	            for(int j=0;j<len;j++) {
	                if(nowbit != bit[j]) {
	                    nowbit = bit[j];
	                    ans++;
	                }
	            }
	            sb.append("#"+(tc+1)+" "+ans+"\n");
	        }
	        System.out.println(sb);
	    }
}
