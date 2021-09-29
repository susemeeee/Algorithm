/*
 * Week8.java
 * Author : 박찬형
 * Created Date : 2021-09-29
 */
package programmers.weekly;

public class Week8 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for(int[] size : sizes){
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            if(width > maxWidth){
                maxWidth = width;
            }
            if(height > maxHeight){
                maxHeight = height;
            }
        }

        return maxWidth * maxHeight;
    }
}
