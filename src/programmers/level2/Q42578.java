/*
 * Q42578.java
 * Author : 박찬형
 * Created Date : 2021-04-27
 */
package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Q42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        int[] results;
        for(String[] cloth : clothes){
            if(!map.containsKey(cloth[1])){
                map.put(cloth[1], 1);
            }
            else {
                map.replace(cloth[1], map.get(cloth[1]) + 1);
            }
        }
        results = new int[map.size()];
        int index = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            results[index++] = entry.getValue() * (getSum(index, results) + 1);
        }
        for(int i : results){
            answer += i;
        }
        return answer;
    }

    public int getSum(int index, int[] results) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += results[i];
        }
        return sum;
    }
}
