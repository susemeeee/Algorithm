/*
 * Week7.java
 * Author : 박찬형
 * Created Date : 2021-09-18
 */
package programmers.weekly;

import java.util.HashSet;
import java.util.Set;

public class Week7 {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Set<Integer> room = new HashSet<>();
        int in = 0;
        int out = 0;
        while(in < enter.length || out < leave.length){
            if(out < leave.length && room.contains(leave[out])){
                room.remove(leave[out]);
                for(int i : room){
                    answer[i - 1]++;
                }
                answer[leave[out++] - 1] += room.size();
            }
            else if(in < enter.length){
                room.add(enter[in++]);
            }
        }
        return answer;
    }
}
