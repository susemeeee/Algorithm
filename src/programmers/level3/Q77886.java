/*
 * Q77886.java
 * Author : 박찬형
 * Created Date : 2021-09-06
 */
package programmers.level3;

import java.util.Stack;

public class Q77886 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length; i++) {
            for(int j = s[i].length() - 1; j >= 0; j--){
                stack.push(s[i].charAt(j));
            }

            StringBuilder sb = new StringBuilder();
            int oneCount = 0;
            Stack<Character> collect = new Stack<>();
            int count = 0;
            while(!stack.isEmpty()){
                if(stack.peek() == '0'){
                    if(oneCount >= 2){
                        stack.pop();
                        collect.pop();
                        collect.pop();
                        count++;
                        oneCount -= 2;
                    }
                    else{
                        collect.push(stack.pop());
                        oneCount = 0;
                    }
                }
                else{
                    oneCount++;
                    collect.push(stack.pop());
                }
            }

            while(!collect.isEmpty() && collect.peek() == '1'){
                stack.push(collect.pop());
            }
            Stack<Character> temp = new Stack<>();
            while(!collect.isEmpty()){
                temp.push(collect.pop());
            }
            while(!temp.isEmpty()){
                sb.append(temp.pop());
            }
            sb.append("110".repeat(count));
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}
