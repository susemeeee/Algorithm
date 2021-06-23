/*
 * Q42586.java
 * Author : 박찬형
 * Created Date : 2021-06-23
 */
package programmers.level2;

import java.util.*;

public class Q42586 {
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0){
                day++;
            }
            queue.add(day);
        }

        List<Integer> result = new ArrayList<>();
        int first = -1;
        int count = 0;
        while(!queue.isEmpty()){
            first = queue.poll();
            count++;
            while(!queue.isEmpty() && queue.peek() <= first){
                queue.poll();
                count++;
            }
            result.add(count);
            count = 0;
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
