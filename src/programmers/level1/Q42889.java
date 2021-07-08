/*
 * Q42889.java
 * Author : 박찬형
 * Created Date : 2021-07-08
 */
package programmers.level1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q42889 {
    static class FailureRate{
        private int stage;
        private float rate;

        public FailureRate(int stage, float rate){
            this.stage = stage;
            this.rate = rate;
        }
    }


    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Queue<Integer> stageInfo = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s : stages){
            stageInfo.add(s);
        }

        Queue<FailureRate> result = new PriorityQueue<>((o1, o2) -> {
            float check = o2.rate - o1.rate;
            if (check < 0){
                return -1;
            }
            else if(check > 0){
                return 1;
            }
            else{
                return o1.stage - o2.stage;
            }
        });

        int total = 0;
        int cur = 0;
        boolean[] checked = new boolean[N];
        while(!stageInfo.isEmpty()){
            cur = 1;
            int s = stageInfo.poll();
            total++;
            while(!stageInfo.isEmpty() && stageInfo.peek() == s){
                stageInfo.poll();
                total++;
                cur++;
            }
            if(s > N){
                continue;
            }

            result.add(new FailureRate(s, (float) cur / total));
            checked[s - 1] = true;
        }

        int index = 0;
        while(!result.isEmpty()){
            FailureRate failureRate = result.poll();
            answer[index++] = failureRate.stage;
        }

        for(int i = 0; i < checked.length && index < checked.length; i++){
            if(!checked[i]){
                answer[index++] = i + 1;
            }
        }

        return answer;
    }
}
