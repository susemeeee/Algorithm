/*
 * Q67257.java
 * Author : 박찬형
 * Created Date : 2021-06-29
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class Q67257 {
    public long solution(String expression) {
        long answer = 0;

        List<String> expressionList = new LinkedList<>();
        int prevIndex = 0;
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c >= '0' && c <= '9'){
                continue;
            }
            expressionList.add(expression.substring(prevIndex, i));
            expressionList.add(expression.substring(i, i + 1));
            prevIndex = i + 1;
        }
        expressionList.add(expression.substring(prevIndex));

        int[][] operatorPriority = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
        for(int i = 0; i < operatorPriority.length; i++){
            List<String> clone = new LinkedList<>(expressionList);
            long result = getResult(operatorPriority[i], clone);
            if(result > answer){
                answer = result;
            }
        }

        return answer;
    }

    public long getResult(int[] operatorPriority, List<String> expression){
        int curPriority = 0;

        for(int i = 1; curPriority <= 2; i++){
            if(i >= expression.size() - 1){
                i = 0;
                curPriority++;
                continue;
            }

            char check = expression.get(i).charAt(0);
            if(check >= '0' && check <= '9'){
                continue;
            }
            if(operatorPriority[operatorIndex(check)] != curPriority){
                continue;
            }

            String s1 = expression.remove(i - 1);
            String op = expression.remove(i - 1);
            String s2 = expression.remove(i - 1);
            expression.add(i - 1, calc(s1, s2, op));
            i--;
        }

        long result = Long.parseLong(expression.get(0));
        return result > 0 ? result : result * -1;
    }

    public int operatorIndex(char op){
        int index = -1;

        switch (op){
            case '+':
                index = 0;
                break;
            case '-':
                index = 1;
                break;
            case '*':
                index = 2;
                break;
        }

        return index;
    }

    public String calc(String s1, String s2, String operator){
        char op = operator.charAt(0);
        long l1 = Long.parseLong(s1);
        long l2 = Long.parseLong(s2);
        long result = 0;

        switch (op){
            case '+':
                result = l1 + l2;
                break;
            case '-':
                result = l1 - l2;
                break;
            case '*':
                result = l1 * l2;
                break;
        }

        return Long.toString(result);
    }
}
