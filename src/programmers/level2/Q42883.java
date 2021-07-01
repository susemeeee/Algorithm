/*
 * Q42883.java
 * Author : 박찬형
 * Created Date : 2021-07-01
 */
package programmers.level2;

import java.util.Stack;

public class Q42883 {
    public String solution(String number, int k) {
        Stack<Character> numberStack = new Stack<>();

        for(int i = number.length() - 1; i >= 0; i--){
            numberStack.push(number.charAt(i));
        }

        int count = 0;
        Stack<Character> stack = new Stack<>();
        while(count < k && numberStack.size() > 1){
            char compare = numberStack.pop();
            if(compare < numberStack.peek()){
                count++;
                if(!stack.isEmpty()){
                    numberStack.push(stack.pop());
                }
            }
            else{
                stack.push(compare);
            }
        }

        while(!numberStack.isEmpty()){
            stack.push(numberStack.pop());
        }
        while(count < k){
            stack.pop();
            count++;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
