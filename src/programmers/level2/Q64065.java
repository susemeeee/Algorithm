/*
 * Q64065.java
 * Author : 박찬형
 * Created Date : 2021-06-28
 */
package programmers.level2;

import java.util.*;

public class Q64065 {
    public int[] solution(String s) {
        String[] sets = s.split("\\{|}");
        Queue<String> queue = new PriorityQueue<>(Comparator.comparingInt(String::length));
        for(String set : sets){
            if(set.length() == 0){
                continue;
            }
            queue.add(set);
        }

        Set<Integer> usedNumbers = new HashSet<>();
        Queue<Integer> tupleQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            String[] set = queue.poll().split(",");
            for (String value : set) {
                int key = Integer.parseInt(value);
                if (usedNumbers.contains(key)) {
                    continue;
                }

                usedNumbers.add(key);
                tupleQueue.add(key);
            }
        }

        int[] answer = new int[tupleQueue.size()];
        int index = 0;
        while(!tupleQueue.isEmpty()){
            answer[index++] = tupleQueue.poll();
        }

        return answer;
    }
}
