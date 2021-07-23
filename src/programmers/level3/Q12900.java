/*
 * Q12900.java
 * Author : 박찬형
 * Created Date : 2021-07-23
 */
package programmers.level3;

public class Q12900 {
    public int solution(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int[] results = new int[n];
        results[0] = 1;
        results[1] = 2;

        for(int i = 2; i < results.length; i++){
            results[i] = (results[i - 2] + results[i - 1]) % 1000000007;
        }

        return results[results.length - 1];
    }
}
