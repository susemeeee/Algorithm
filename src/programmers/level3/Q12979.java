/*
 * Q12979.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level3;

public class Q12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int nextStart = 0;
        int range = w * 2 + 1;
        for(int i : stations){
            answer += ceil((double) ((i - w - 1) - nextStart) / range);
            nextStart = i + w;
        }

        if(nextStart < n){
            answer += ceil((double) (n - nextStart) / range);
        }

        return answer;
    }

    private int ceil(double d){
        if(d < 1){
            return d > 0 ? (int)d + 1 : 0;
        }
        return d % (int)d > 0 ? (int)d + 1 : (int)d;
    }
}
