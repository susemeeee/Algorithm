/*
 * Q12927.java
 * Author : 박찬형
 * Created Date : 2021-08-12
 */
package programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w : works){
            queue.add(w);
        }

        for(int i = 0; i < n; i++){
            queue.add(queue.poll() - 1);
            if(queue.peek() == 0){
                break;
            }
        }

        while(!queue.isEmpty() && queue.peek() != 0){
            int w = queue.poll();
            answer += (long) w * w;
        }

        return answer;
    }
}
