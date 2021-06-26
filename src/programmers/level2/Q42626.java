/*
 * Q42626.java
 * Author : 박찬형
 * Created Date : 2021-06-26
 */
package programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> sortedScoville = new PriorityQueue<>(Integer::compareTo);
        for(int i : scoville){
            sortedScoville.add(i);
        }

        while(sortedScoville.peek() < K){
            if(sortedScoville.size() < 2){
                return -1;
            }

            int food1 = sortedScoville.poll();
            int food2 = sortedScoville.poll();

            sortedScoville.add(food1 + (food2 * 2));
            answer++;
        }

        return answer;
    }
}
