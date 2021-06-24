/*
 * Q12899.java
 * Author : 박찬형
 * Created Date : 2021-06-24
 */
package programmers.level2;

import java.util.Stack;

public class Q12899 {
    public String solution(int n){
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            int mod = n % 3;
            switch (mod){
                case 1:
                case 2:
                    stack.push(mod);
                    break;
                case 0:
                    stack.push(4);
                    n--;
                    break;
            }
            if(n <= 3){
                break;
            }

            n /= 3;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
