/*
 * Q42895.java
 * Author : 박찬형
 * Created Date : 2021-07-12
 */
package programmers.level3;

public class Q42895 {
    private int min;

    public int solution(int N, int number) {
        min = 9;

        int value = N;
        for(int i = 1; i < 8; i++){
            makeNumber(N, number, i, value);
            value = value * 10 + N;
        }
        if(min == 9){
            return -1;
        }

        return min;
    }

    public void makeNumber(int n, int number, int count, int value) {
        if(count >= min){
            return;
        }
        if(value == number){
            min = count;
            return;
        }

        int newValue = n;
        for(int i = 1; i + count < min; i++){
            makeNumber(n, number, count + i, value + newValue);
            makeNumber(n, number, count + i, value - newValue);
            makeNumber(n, number, count + i, value * newValue);
            makeNumber(n, number, count + i, value / newValue);

            makeNumber(n, number, count + i, newValue - value);
            if(value != 0){
                makeNumber(n, number, count + i, newValue / value);
            }

            newValue = newValue * 10 + n;
        }
    }
}
