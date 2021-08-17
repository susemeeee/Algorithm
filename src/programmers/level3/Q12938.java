/*
 * Q12938.java
 * Author : 박찬형
 * Created Date : 2021-08-17
 */
package programmers.level3;

public class Q12938 {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int div = s / n;
        int mod = s % n;

        for(int i = n - 1; i >= 0; i--){
            answer[i] = mod > 0 ? div + 1 : div;
            mod--;
        }

        return answer;
    }
}
