/*
 * Q42888.java
 * Author : 박찬형
 * Created Date : 2021-06-21
 */
package programmers.level2;

import java.util.*;

public class Q42888 {
    enum State{
        ENTER, EXIT
    }

    class ChatStatus{
        private String userId;
        private State state;

        public ChatStatus(String userId, State state){
            this.userId = userId;
            this.state = state;
        }

        public String generateMessage(String userName){
            StringBuilder sb = new StringBuilder();
            sb.append(userName).append("님이 ").append(state == State.ENTER ? "들어왔습니다." : "나갔습니다.");
            return sb.toString();
        }
    }

    public String[] solution(String[] record){
        Map<String, String> userNames = new HashMap<>();
        Queue<ChatStatus> queue = new LinkedList<>();

        for(String r : record){
            String[] stat = r.split(" ");
            System.out.println(Arrays.toString(stat));
            if(stat[0].equals("Enter")){
                userNames.put(stat[1], stat[2]);
                queue.add(new ChatStatus(stat[1], State.ENTER));
            }
            else if(stat[0].equals("Leave")){
                queue.add(new ChatStatus(stat[1], State.EXIT));
            }
            else{
                userNames.replace(stat[1], stat[2]);
            }
        }

        String[] result = new String[queue.size()];
        int index = 0;
        while(!queue.isEmpty()){
            ChatStatus chatStatus = queue.poll();
            result[index++] = chatStatus.generateMessage(userNames.get(chatStatus.userId));
        }

        return result;
    }
}
