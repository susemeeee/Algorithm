/*
 * Q12936.java
 * Author : 박찬형
 * Created Date : 2021-08-16
 */
package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Q12936 {
    public int[] solution(int n, long k) {
        if(n == 1){
            return new int[]{1};
        }

        int[] answer = new int[n];
        long value = 1;
        for(int i = 2; i < n; i++){
            value *= i;
        }
        int index = 0;

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }

        for(int i = n - 1; i > 1; i--){
            int next = k % value == 0 ? (int) (k / value) : (int) (k / value + 1);

            answer[index++] = numbers.remove(next - 1);
            k %= value;
            if(k == 0){
                k = value;
            }
            value /= i;
        }

        boolean reverse = k % 2 == 0;
        answer[index++] = numbers.get(reverse ? 1 : 0);
        answer[index] = numbers.get(reverse ? 0 : 1);

        return answer;
    }
}
