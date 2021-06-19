/*
 * Q12913.java
 * Author : 박찬형
 * Created Date : 2021-06-19
 */
package programmers.level2;

public class Q12913 {
    public int solution(int[][] land){
        int answer = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                land[i][j] += max(land[i - 1], j);
            }
        }
        return max(land[land.length - 1], -1);
    }

    public int max(int[] arr, int excludeIndex){
        int max;
        if(excludeIndex == 0){
            max = arr[1];
        }
        else{
            max = arr[0];
        }

        for(int i = 0; i < arr.length; i++){
            if(i == excludeIndex){
                continue;
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }
}
