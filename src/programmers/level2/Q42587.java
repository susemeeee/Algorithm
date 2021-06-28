/*
 * Q42587.java
 * Author : 박찬형
 * Created Date : 2021-06-28
 */
package programmers.level2;

import java.util.*;

public class Q42587 {
    class PrintTarget{
        private int priority;
        private int location;

        public PrintTarget(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<PrintTarget> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(new PrintTarget(priorities[i], i));
        }

        int rank = 1;
        int max = getMaxPriority(queue);
        while(!queue.isEmpty()){
            while(!queue.isEmpty() && queue.peek().priority != max){
                queue.add(queue.poll());
            }

            if(queue.poll().location == location){
                break;
            }

            max = getMaxPriority(queue);
            rank++;
        }

        return rank;
    }

    public int getMaxPriority(Queue<PrintTarget> queue){
        return queue.stream().max(Comparator.comparingInt(o -> o.priority)).get().priority;
    }
}
