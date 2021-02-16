/*
 * Q11726.java
 * Author : 박찬형
 * Created Date : 2021-02-16
 */
package BOJ.dp;

import java.util.Scanner;

public class Q11726 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] results = new long[n];
        results[0] = 1;
        if(n > 1){
            results[1] = 2;
        }
        for(int i = 2; i < n; i++){
            results[i] = (results[i - 2] + results[i - 1]) % 10007;
        }

        System.out.println(results[n - 1]);
    }
}
