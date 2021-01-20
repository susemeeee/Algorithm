/*
 * Q1439.java
 * Author : 박찬형
 * Created Date : 2021-01-20
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q1439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int[] charCounts = new int[2];

        char cur = 0;
        for(int i = 0; i < input.length; i++){
            if(cur == 0){
                cur = input[i];
                charCounts[input[i] - '0']++;
                continue;
            }

            if(input[i] != cur){
                cur = input[i];
                charCounts[input[i] - '0']++;
            }
        }

        System.out.println(Math.min(charCounts[0], charCounts[1]));
    }
}
