/*
 * Q12939.java
 * Author : 박찬형
 * Created Date : 2021-07-11
 */
package programmers.level2;

public class Q12939 {
    public String solution(String s) {
        String[] split = s.split(" ");

        int min = Integer.parseInt(split[0]);
        int max = min;

        for(int i = 1; i < split.length; i++){
            int item = Integer.parseInt(split[i]);

            if(item < min){
                min = item;
            }
            if(item > max){
                max = item;
            }
        }

        return min + " " + max;
    }
}
