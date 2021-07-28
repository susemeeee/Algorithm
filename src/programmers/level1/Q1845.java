/*
 * Q1845.java
 * Author : 박찬형
 * Created Date : 2021-07-28
 */
package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class Q1845 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        return Math.min(nums.length / 2, set.size());
    }
}
