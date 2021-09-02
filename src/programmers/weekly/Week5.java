/*
 * Week5.java
 * Author : 박찬형
 * Created Date : 2021-09-02
 */
package programmers.weekly;

import java.util.HashMap;
import java.util.Map;

public class Week5 {
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        int answer = 0;
        int count = 0;
        for(int i = 0 ; i < 5; i++){
            if(i < word.length()){
                count += map.get(word.charAt(i));
                answer++;
            }
            answer += count * Math.pow(5, 4 - i);
        }
        return answer;
    }
}
