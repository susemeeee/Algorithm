/*
 * Q42748.java
 * Author : 박찬형
 * Created Date : 2021-04-30
 */
package programmers.level1;

import java.util.Arrays;

public class Q42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] arr = array.clone();
            Arrays.sort(arr, commands[i][0] - 1, commands[i][1]);
            System.out.println(Arrays.toString(arr));
            answer[i] = arr[commands[i][0] + commands[i][2] - 2];
        }

        return answer;
    }
}
