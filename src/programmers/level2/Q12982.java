/*
 * Q12982.java
 * Author : 박찬형
 * Created Date : 2021-05-03
 */
package programmers.level2;

import java.util.Arrays;

public class Q12982 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            budget -= d[i];
            if(budget < 0){
                break;
            }
            answer++;
        }
        return answer;
    }
}
