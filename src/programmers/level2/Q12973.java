/*
 * Q12973.java
 * Author : 박찬형
 * Created Date : 2021-06-24
 */
package programmers.level2;

import java.util.Stack;

public class Q12973 {
    public int solution(String s){
        Stack<Character> inputStack = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            inputStack.push(c);
        }
        while(!inputStack.isEmpty()){
            char c = inputStack.pop();
            if(inputStack.isEmpty()){
                stack.push(c);
                break;
            }

            if(c == inputStack.peek()){
                inputStack.pop();
                if(!stack.isEmpty()){
                    inputStack.push(stack.pop());
                }
            }
            else{
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }
}
