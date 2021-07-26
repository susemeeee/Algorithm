/*
 * Q17678.java
 * Author : 박찬형
 * Created Date : 2021-07-26
 */
package programmers.level3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<LocalTime> queue = new PriorityQueue<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for(String time : timetable){
            queue.add(LocalTime.parse(time, formatter));
        }

        LocalTime curTime = LocalTime.parse("09:00", formatter);
        LocalTime lateTime = curTime.minusMinutes(1);

        for(int i = 0; i < n; i++){
            int count = 0;
            while(!queue.isEmpty() && count < m - 1 && !queue.peek().isAfter(curTime)){
                queue.poll();
                count++;
            }

            if(count < m){
                lateTime = curTime;
            }
            if(!queue.isEmpty() && count < m && !queue.peek().isAfter(curTime)){
                lateTime = queue.poll().minusMinutes(1);
            }

            curTime = curTime.plusMinutes(t);
        }

        return lateTime.toString();
    }
}
