/*
 * Q76502.java
 * Author : 박찬형
 * Created Date : 2021-07-05
 */
package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q76502 {
    private Map<Character, Character> pair;

    public int solution(String s) {
        int answer = 0;
        if(s.length() == 1){
            return answer;
        }

        init();

        for(int i = 0; i < s.length(); i++){
            s = s.substring(1) + s.charAt(0);
            if(checkCorrect(s)){
                answer++;
            }
        }
        return answer;
    }

    private void init(){
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
    }

    private boolean checkCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char check = s.charAt(i);
            if(!pair.containsKey(check)){
                stack.push(check);
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == pair.get(check)){
                stack.pop();
            }
            else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}
