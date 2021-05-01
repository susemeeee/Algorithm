/*
 * Q42747.java
 * Author : 박찬형
 * Created Date : 2021-05-01
 */
package programmers.level2;

import java.util.Arrays;

public class Q42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h = 0;
        int index = 0;
        while(h <= citations[citations.length - 1] && index < citations.length){
            if(h > citations[index]){
                index++;
                continue;
            }
            if(citations.length - index >= h && h > answer){
                answer = h;
            }
            h++;
        }
        return answer;
    }
}
