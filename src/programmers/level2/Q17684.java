/*
 * Q17684.java
 * Author : 박찬형
 * Created Date : 2021-07-18
 */
package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17684 {
    public int[] solution(String msg) {
        List<Integer> collect = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int start = 0;
        int end = 1;

        for(int i = 1; i <= 26; i++){
            dictionary.put(String.valueOf((char)('A' + (i - 1))), i);
        }

        if(msg.length() == 1){
            collect.add(dictionary.get(msg));
            return toArray(collect);
        }

        int dictionaryNumber = 27;
        while(start < msg.length()){
            int value = dictionary.get(msg.substring(start, end));

            while(end < msg.length() && dictionary.containsKey(msg.substring(start, ++end))){
                value = dictionary.get(msg.substring(start, end));
            }

            collect.add(value);

            if(dictionary.containsKey(msg.substring(start, end))){
                break;
            }

            dictionary.put(msg.substring(start, end), dictionaryNumber++);
            start = end - 1;
        }

        return toArray(collect);
    }

    private int[] toArray(List<Integer> list){
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
