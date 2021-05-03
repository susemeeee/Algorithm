/*
 * Q12977.java
 * Author : 박찬형
 * Created Date : 2021-05-03
 */
package programmers.level2;

public class Q12977 {
    private int count;

    public int solution(int[] nums) {
        count = 0;

        for(int i = 0; i < nums.length - 2; i++){
            makeNumber(nums, i, 1, nums[i]);
        }

        return count;
    }

    public void makeNumber(int[] nums, int index, int depth, int sum){
        if(depth == 3){
            if(isPrime(sum)){
                count++;
            }
            return;
        }

        for(int i = index + 1; i < nums.length; i++){
            makeNumber(nums, i, depth + 1, sum + nums[i]);
        }
    }

    private boolean isPrime(int n){
        if(n == 1){
            return false;
        }

        for(int i = 2; i < n / 2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
