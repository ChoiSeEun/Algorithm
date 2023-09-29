import java.util.*;
import java.io.*;

public class Swea_D3_1208_Flatten {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			int cnt = Integer.parseInt(br.readLine());
			
			List<Integer> boxes = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i=0;i<100;i++) boxes.add(Integer.parseInt(st.nextToken())); 
			
			for(int i=0;i<cnt;i++) {
				int max_height = Collections.max(boxes);
				int min_height = Collections.min(boxes);
				
				int max_idx = boxes.indexOf(max_height);
				int min_idx = boxes.indexOf(min_height);
				
				boxes.set(max_idx, boxes.get(max_idx)-1);
				boxes.set(min_idx, boxes.get(min_idx)+1);
			}
			int diff = Collections.max(boxes) - Collections.min(boxes);
			sb.append("#").append(tc).append(" ").append(diff).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
