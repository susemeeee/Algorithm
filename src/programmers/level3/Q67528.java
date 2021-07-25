/*
 * Q67528.java
 * Author : 박찬형
 * Created Date : 2021-07-25
 */
package programmers.level3;

import java.util.*;

public class Q67528 {
    public int[] solution(String[] gems) {
        int[] answer = null;
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

        int start = 0;
        int end = 0;
        Map<String, Integer> containedGem = new HashMap<>();
        Set<String> collect = new HashSet<>();

        for(String gem : gemSet){
            containedGem.put(gem, 0);
        }

        while(end < gems.length){
            String gem = gems[end];

            if(containedGem.get(gem) == 0){
                collect.add(gem);
            }
            containedGem.replace(gem, containedGem.get(gem) + 1);
            while(containedGem.get(gems[start]) > 1){
                containedGem.replace(gems[start], containedGem.get(gems[start]) - 1);
                start++;
            }

            if(collect.size() == gemSet.size()){
                if(answer == null){
                    answer = new int[]{start + 1, end + 1};
                }
                else if(end - start < answer[1] - answer[0]){
                    answer = new int[]{start + 1, end + 1};
                }
            }

            end++;
        }

        return answer;
    }
}
