/*
 * Q1449.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q1449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int[] fix = new int[n];
        input = scanner.nextLine().split(" ");

        for(int i = 0; i < n; i++){
            fix[i] = Integer.parseInt(input[i]);
        }

        if(n == 1){
            System.out.println(1);
            return;
        }
        if(l == 1){
            System.out.println(n);
            return;
        }

        Arrays.sort(fix);

        int count = 0;

        for(int i = 0; i < n; i++){
            count++;
            int start = fix[i];
            while(i < n - 1 && (fix[i + 1] < start + l)){
                i++;
            }
        }

        System.out.println(count);
    }
}
