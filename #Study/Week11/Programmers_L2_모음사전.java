import java.util.*;

public class Programmers_L2_모음사전 {
	
	static final char[] alpha = {'A','E','I','O','U'};

	public static void main(String[] args) throws Exception {
		System.out.println(solution("AAAAE"));
	}
	public static int solution(String word) {
        int answer = 0;
        List<String> words = new ArrayList<>();
        
        for(int i=0;i<5;i++)
            dfs(words,String.valueOf(alpha[i]));
        
        for(int i=0;i<words.size();i++){
            if(words.get(i).equals(word)){
                answer = i +1;
                break;
            }
        }
        return answer;
    }
	public static void dfs(List<String>words,String str){
        if(str.length()>5) return;
        if(!words.contains(str)) words.add(str);
        for(int i=0;i<5;i++){
            dfs(words,str+alpha[i]);
        }
    }
}
