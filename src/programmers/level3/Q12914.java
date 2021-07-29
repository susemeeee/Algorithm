/*
 * Q12914.java
 * Author : 박찬형
 * Created Date : 2021-07-29
 */
package programmers.level3;

public class Q12914 {
    public long solution(int n) {
        if(n <= 2){
            return n;
        }

        long[] record = new long[n];
        record[0] = 1;
        record[1] = 2;
        for(int i = 2; i < n; i++){
            record[i] = (record[i - 2] + record[i - 1]) % 1234567;
        }

        return record[n - 1];
    }
}
