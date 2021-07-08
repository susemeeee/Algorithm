/*
 * Q42584.java
 * Author : 박찬형
 * Created Date : 2021-07-08
 */
package programmers.level2;

import java.util.Stack;

public class Q42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> priceStack = new Stack<>();
        for(int i = prices.length - 1; i >= 0; i--){
            priceStack.push(prices[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length - 1; i++){
            int price = priceStack.pop();
            while(!priceStack.isEmpty()){
                answer[i]++;
                if(price <= priceStack.peek()){
                    stack.push(priceStack.pop());
                }
                else{
                    break;
                }
            }
            while(!stack.isEmpty()){
                priceStack.push(stack.pop());
            }
        }
        return answer;
    }
}
