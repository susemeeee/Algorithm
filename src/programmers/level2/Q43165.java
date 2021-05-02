/*
 * Q43165.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level2;

public class Q43165 {
    private int target;
    private int count;
    private int[] numbers;

    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        count = 0;
        check(0, 0);
        return count;
    }

    private void check(int sum, int index){
        if(index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }

        check(sum + numbers[index], index + 1);
        check(sum - numbers[index], index + 1);
    }
}
