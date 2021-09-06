/*
 * Q68646.java
 * Author : 박찬형
 * Created Date : 2021-09-06
 */
package programmers.level3;

public class Q68646 {
    public int solution(int[] a) {
        int answer = 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;

        for(int i = 0; i < a.length - 1; i++){
            left[i + 1] = Math.min(a[i], left[i]);
        }
        for(int i = a.length - 1; i > 0; i--){
            right[i - 1] = Math.min(a[i], right[i]);
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] > left[i] && a[i] > right[i]){
                continue;
            }
            answer++;
        }
        return answer;
    }
}
