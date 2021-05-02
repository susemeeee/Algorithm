/*
 * Q42840.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q42840 {
    private Queue<Integer>[] queues;

    public int[] solution(int[] answers) {
        Queue<Integer> result = new LinkedList<>();
        int[] count = new int[3];
        initData();
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < queues.length; j++){
                int item = queues[j].poll();
                if(item == answers[i]){
                    count[j]++;
                }
                queues[j].add(item);
            }
        }

        int maxCount = Arrays.stream(count).max().getAsInt();
        for(int i = 0; i < count.length; i++){
            if(count[i] == maxCount){
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        int index = 0;
        while(!result.isEmpty()){
            answer[index++] = result.poll();
        }

        return answer;
    }

    private void initData(){
        queues = new Queue[3];

        for(int i = 0; i < queues.length; i++){
            queues[i] = new LinkedList<>();
        }

        for(int i = 0; i < 5; i++){
            queues[0].add(i + 1);
        }

        int[] data = {1, 3, 4, 5};
        int index = 0;
        for(int i = 0; i < 8; i++){
            if(i % 2 == 0){
                queues[1].add(2);
                continue;
            }
            queues[1].add(data[index++]);
        }

        int[] data2 = {3, 1, 2, 4, 5};
        int count = 0;
        for(int i = 0; i < data2.length;){
            if(count < 2){
                queues[2].add(data2[i]);
                count++;
            }
            else{
                i++;
                count = 0;
            }
        }
    }
}
