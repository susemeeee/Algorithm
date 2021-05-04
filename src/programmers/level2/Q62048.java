/*
 * Q62048.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level2;

public class Q62048 {
    public long solution(int w, int h) {
        long count = (long) w * h;
        long repeat = getRepeatCount(w, h);
        long cellX = w / repeat;
        long cellY = h / repeat;
        return count - repeat * (cellX + cellY - 1);
    }

    private int getRepeatCount(int w, int h){
        int target = Math.max(w, h);
        int check = Math.min(w, h);
        for(int i = check; i > 1; i--){
            if(target % i == 0 && check % i == 0){
                return i;
            }
        }

        return 1;
    }
}
