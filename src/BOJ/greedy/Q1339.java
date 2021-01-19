/*
 * Q1339.java
 * Author : 박찬형
 * Created Date : 2021-01-15
 */
package BOJ.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1339 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        scanner.nextLine();
        Integer[] nums = new Integer[26];

        Arrays.fill(nums, 0);

        for(int i = 0; i < wordCount; i++){
            String word = scanner.nextLine();
            for(int j = 0; j < word.length(); j++){
                nums[word.charAt(j) - 'A'] += (int) Math.pow(10, (word.length() - j - 1));
            }
        }

        Arrays.sort(nums, Comparator.reverseOrder());
        int sum = 0;
        int current = 9;

        for(int i = 0; i < nums.length; i++){
            sum += current * nums[i];
            current--;
        }

        System.out.println(sum);
    }
}
