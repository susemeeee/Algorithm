/*
 * Q43105.java
 * Author : 박찬형
 * Created Date : 2021-07-17
 */
package programmers.level3;

public class Q43105 {
    public int solution(int[][] triangle) {
        for(int i = triangle.length - 1; i > 0; i--){
            for(int j = 0; j < triangle[i].length - 1; j++){
                if(triangle[i][j] >= triangle[i][j + 1]){
                    triangle[i - 1][j] += triangle[i][j];
                }
                else{
                    triangle[i - 1][j] += triangle[i][j + 1];
                }
            }
        }
        return triangle[0][0];
    }
}
