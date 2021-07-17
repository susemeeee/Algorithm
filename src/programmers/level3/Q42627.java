/*
 * Q42627.java
 * Author : 박찬형
 * Created Date : 2021-07-17
 */
package programmers.level3;

import java.util.*;

public class Q42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> wait = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int time = 0;
        List<Integer> result = new ArrayList<>();

        int index = 0;
        while(index < jobs.length) {
            while(index < jobs.length && time >= jobs[index][0]){
                wait.add(jobs[index++]);
            }
            if(!wait.isEmpty()){
                int[] cur = wait.poll();
                time += cur[1];
                result.add(time - cur[0]);
            }
            else{
                time++;
            }
        }

        while(!wait.isEmpty()){
            int[] cur = wait.poll();
            time += cur[1];
            result.add(time - cur[0]);
        }

        for(int r : result){
            answer += r;
        }

        return answer / jobs.length;
    }
}
