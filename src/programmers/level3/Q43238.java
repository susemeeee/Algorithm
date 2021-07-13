/*
 * Q43238.java
 * Author : 박찬형
 * Created Date : 2021-07-13
 */
package programmers.level3;

public class Q43238 {
    public long solution(int n, int[] times) {
        long sum = 0;
        long max = 0;

        for(int t : times){
            if(t > max){
                max = t;
            }
        }

        long end = max * n;
        long start = 0;
        long mid = start + (end - start) / 2;

        while(end - start > 0){
            for (int t : times) {
                sum += mid / t;
            }

            if(sum < n){
                start = mid + 1;
            }
            else{
                end = mid;
            }
            sum = 0;
            mid = start + (end - start) / 2;
        }

        return mid;
    }
}
