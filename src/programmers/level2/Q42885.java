/*
 * Q42885.java
 * Author : 박찬형
 * Created Date : 2021-07-07
 */
package programmers.level2;

import java.util.Arrays;

public class Q42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int cur = people.length - 1;
        int end = 0;
        while(cur >= end){
            if(people[cur] + people[end] <= limit){
                cur--;
                end++;
            }
            else{
                cur--;
            }
            answer++;
        }

        return answer;
    }
}
