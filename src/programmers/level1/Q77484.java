/*
 * Q77484.java
 * Author : 박찬형
 * Created Date : 2021-04-27
 */
package programmers.level1;

import java.util.Arrays;

public class Q77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int rank = 6;
        int unknownCount = 0;
        int count = 0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int n : lottos){
            if(n == 0){
                unknownCount++;
            }
        }

        for(int i = unknownCount, j = 0; i < lottos.length && j < win_nums.length;){
            if(lottos[i] == win_nums[j]){
                count++;
                i++;
                j++;
            }
            else if(lottos[i] > win_nums[j]){
                j++;
            }
            else{
                i++;
            }
        }
        int minCount = count;
        int maxCount = count + unknownCount;

        int[] answer = {maxCount >= 2 ? rank - maxCount + 1 : 6, minCount >= 2 ? rank - minCount + 1 : 6};
        return answer;
    }
}
