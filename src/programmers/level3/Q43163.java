/*
 * Q43163.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean notContain = true;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                notContain = false;
                break;
            }
        }

        if(notContain){
            return 0;
        }

        for(int i = 0; i < words.length; i++) {
            if(checkNextStep(begin, words[i])){
                int step = visit(words, i, target);
                if(answer == 0 || step < answer){
                    answer = step;
                }
            }
        }
        return answer;
    }

    private int visit(String[] words, int index, String target){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited.add(index);
        int stepCount = 1;
        int nextStepCount = 0;
        int count = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 0; i < words.length; i++){
                if(!visited.contains(i) && checkNextStep(words[cur], words[i])){
                    visited.add(i);
                    queue.add(i);
                    nextStepCount++;
                }
            }

            if(--stepCount == 0){
                count++;
                stepCount = nextStepCount;
                nextStepCount = 0;
            }
            if(words[cur].equals(target)){
                break;
            }
        }

        return count;
    }

    private boolean checkNextStep(String s1, String s2){
        int count = 0;
        if(s1.equals(s2)){
            return false;
        }

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }

        return true;
    }
}
