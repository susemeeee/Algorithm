/*
 * Q12945.java
 * Author : 박찬형
 * Created Date : 2021-07-12
 */
package programmers.level2;

public class Q12945 {
    public int solution(int n) {
        int answer = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i < result.length; i++){
            result[i] = (result[i - 2] + result[i - 1]) % 1234567;
        }

        return result[result.length - 1];
    }
}
