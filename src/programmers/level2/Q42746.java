/*
 * Q42746.java
 * Author : 박찬형
 * Created Date : 2021-04-30
 */
package programmers.level2;

import java.util.*;

public class Q42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        boolean allZero = true;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != 0){
                allZero = false;
            }
            arr[i] = Integer.toString(numbers[i]);
        }
        if(allZero){
            return "0";
        }
        Arrays.sort(arr, this::compare);

        StringBuilder answer = new StringBuilder();
        for(String s : arr){
            answer.append(s);
        }

        return answer.toString();
    }

    private int compare(String o1, String o2){
        int s1 = Integer.parseInt(o1 + o2);
        int s2 = Integer.parseInt(o2 + o1);
        return s2 - s1;
    }
}
