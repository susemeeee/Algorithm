/*
 * Q12949.java
 * Author : 박찬형
 * Created Date : 2021-07-12
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        Queue<Integer> collect = new LinkedList<>();
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                int value = 0;
                for(int k = 0; k < arr2.length; k++){
                    value += arr1[i][k] * arr2[k][j];
                }
                collect.add(value);
            }
        }

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                answer[i][j] = collect.poll();
            }
        }
        return answer;
    }
}
