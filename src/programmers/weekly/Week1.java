/*
 * Week1.java
 * Author : 박찬형
 * Created Date : 2021-08-04
 */
package programmers.weekly;

public class Week1 {
    public long solution(int price, int money, int count) {
        long result = money;
        for(int i = 1; i <= count; i++){
            result -= (long) i * price;
        }
        return result >= 0 ? 0 : result * -1;
    }
}
