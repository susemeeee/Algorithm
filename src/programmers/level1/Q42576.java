/*
 * Q42576.java
 * Author : 박찬형
 * Created Date : 2021-04-26
 */
package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Q42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : completion){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }
            else{
                map.replace(s, map.get(s) + 1);
            }
        }
        for(String s : participant){
            if(!map.containsKey(s)){
                return s;
            }
            map.replace(s, map.get(s) - 1);
        }
        for(Map.Entry<String, Integer> item : map.entrySet()){
            if(item.getValue() != 0){
                return item.getKey();
            }
        }
        return "";
    }
}
