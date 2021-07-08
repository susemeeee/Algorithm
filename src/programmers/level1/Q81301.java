/*
 * Q81301.java
 * Author : 박찬형
 * Created Date : 2021-07-08
 */
package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Q81301 {
    private Map<String, Integer> table;

    public int solution(String s) {
        init();
        StringBuilder result = new StringBuilder();
        StringBuilder collect = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isNumber(c)){
                result.append(c);
            }
            else{
                collect.append(c);
                if(collect.length() >= 3 && table.containsKey(collect.toString())){
                    result.append(table.get(collect.toString()));
                    collect = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    private void init(){
        table = new HashMap<>();
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);
        table.put("four", 4);
        table.put("five", 5);
        table.put("six", 6);
        table.put("seven", 7);
        table.put("eight", 8);
        table.put("nine", 9);
        table.put("zero", 0);
    }

    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}
