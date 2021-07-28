/*
 * Q64062.java
 * Author : 박찬형
 * Created Date : 2021-07-28
 */
package programmers.level3;

import java.util.*;

public class Q64062 {
    static class Stone{
        private final int index;
        private final int value;

        public Stone(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public int solution(int[] stones, int k) {
        int answer;
        Queue<Stone> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        int[] removed = new int[stones.length + 1];

        for(int i = 0; i < stones.length; i++){
            queue.add(new Stone(i, stones[i]));
        }

        int curNum = queue.peek().value;
        answer = curNum;
        while(!queue.isEmpty()){
            Stone remove = queue.poll();
            int find = remove.index;

            while(find >= 0){
                if(find == 0 || removed[find] != -1){
                    removed[find] += removed[remove.index + 1] + 1;
                    break;
                }

                find--;
            }

            if(removed[find] >= k){
                break;
            }

            removed[remove.index + 1] = -1;
            if(!queue.isEmpty() && queue.peek().value != curNum){
                answer += queue.peek().value - curNum;
                curNum = queue.peek().value;
            }
        }

        return answer;
    }
}
