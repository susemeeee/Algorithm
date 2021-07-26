/*
 * Q12901.java
 * Author : 박찬형
 * Created Date : 2021-07-26
 */
package programmers.level1;

import java.time.LocalDate;

public class Q12901 {
    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }
}