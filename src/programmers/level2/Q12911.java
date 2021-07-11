/*
 * Q12911.java
 * Author : 박찬형
 * Created Date : 2021-07-11
 */
package programmers.level2;

public class Q12911 {
    public int solution(int n) {
        int originalCount = getCount(n);
        int newCount = getCount(++n);

        while(originalCount != newCount){
            newCount = getCount(++n);
        }

        return n;
    }

    private int getCount(int n){
        int count = 0;

        while(n > 0){
            if(n % 2 == 1){
                count++;
            }

            n /= 2;
        }

        return count;
    }
}
