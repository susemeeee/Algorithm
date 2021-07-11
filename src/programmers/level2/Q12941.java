/*
 * Q12941.java
 * Author : 박찬형
 * Created Date : 2021-07-11
 */
package programmers.level2;

import java.util.Arrays;

public class Q12941 {
    public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length - 1 - i];
        }
        return answer;
    }
}
