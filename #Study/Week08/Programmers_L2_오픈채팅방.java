package ssafy.study.Week08;

import java.io.*;
import java.util.*;

public class Programmers_L2_오픈채팅방 {

    public static void main(String[] args) throws Exception{
        String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(answer));
    }
    static class Message{
        String userId;
        String description;
        public Message(String userId,String description){
            this.userId = userId;
            this.description = description;
        }
    }
    public static String[] solution(String[] record) {
        HashMap<String,String> idNickname = new HashMap<>();
        ArrayDeque<Message> tempMessage  = new ArrayDeque<>();
        StringTokenizer st;
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname="";
            switch(command){
                case "Enter":
                    nickname = st.nextToken();
                    // userID 가 존재하면 값만 변경됨
                    idNickname.put(userId,nickname);
                    tempMessage.offer(new Message(userId, "님이 들어왔습니다."));
                    break;

                case "Leave":
                    tempMessage.offer(new Message(userId, "님이 나갔습니다."));
                    break;

                case "Change":
                    nickname = st.nextToken();
                    // userID 가 존재하면 값만 변경됨
                    idNickname.put(userId,nickname);
                    break;
            }
        }
        int size = tempMessage.size();
        String[] answer = new String[size];
        for(int i=0;i<size;i++){
            Message M = tempMessage.poll();
            answer[i] = idNickname.get(M.userId) + M.description;
        }
        return answer;
    }
}
