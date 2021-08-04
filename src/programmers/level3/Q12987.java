/*
 * Q12987.java
 * Author : 박찬형
 * Created Date : 2021-08-04
 */
package programmers.level3;

import java.util.Arrays;

public class Q12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        while(aIndex < A.length && bIndex < B.length){
            if(A[aIndex] < B[bIndex]){
                answer++;
                aIndex++;
            }
            bIndex++;
        }

        return answer;
    }
}
