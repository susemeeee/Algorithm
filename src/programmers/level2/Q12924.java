/*
 * Q12924.java
 * Author : 박찬형
 * Created Date : 2021-07-11
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q12924 {
    public int solution(int n) {
        int answer = 0;

        int sum = 0;
        int curElement = 1;
        Queue<Integer> elements = new LinkedList<>();
        while(true){
            if(sum < n){
                elements.add(curElement);
                sum += curElement++;
            }

            if(sum == n){
                answer++;
            }
            if(curElement > n / 2 + 1){
                while(sum > n){
                    sum -= elements.poll();
                    if(sum == n){
                        answer++;
                    }
                }
                break;
            }

            if(sum >= n){
                sum -= elements.poll();
            }
        }

        return answer + 1;
    }
}
