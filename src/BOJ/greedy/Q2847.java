/*
 * Q2847.java
 * Author : 박찬형
 * Created Date : 2021-01-20
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q2847 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];

        for(int i = 0; i < n; i++){
            scores[i] = scanner.nextInt();
        }

        if(n == 1){
            System.out.println(0);
            return;
        }

        int count = 0;
        int cur = scores[scores.length - 1];

        for(int i = scores.length - 2; i >= 0; i--){
            if(scores[i] >= cur){
                count += scores[i] - cur + 1;
                scores[i] = cur - 1;
            }

            cur = scores[i];
        }

        System.out.println(count);
    }
}
