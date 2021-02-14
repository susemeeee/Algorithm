/*
 * Q9095.java
 * Author : 박찬형
 * Created Date : 2021-02-14
 */
package BOJ.dp;

import java.util.Scanner;

public class Q9095 {
    static int[] results;
    static int cur = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        int[] inputs = new int[tests];
        int max = -1;
        for(int i = 0; i < tests; i++){
            inputs[i] = scanner.nextInt();
            if(inputs[i] > max){
                max = inputs[i];
            }
        }
        results = new int[max];
        results[0] = 1;
        results[1] = 2;
        results[2] = 4;
        for(int i = 0; i < tests; i++){
            if(inputs[i] < 4){
                System.out.println(results[inputs[i] - 1]);
            }
            else{
                test(inputs[i]);
            }
        }
    }

    static void test(int n){
        if(n < cur){
            System.out.println(results[n - 1]);
            return;
        }

        for(int i = cur; i < n; i++){
            results[i] = results[i - 3] + results[i - 2] + results[i - 1];
            cur++;
        }

        System.out.println(results[n - 1]);
    }
}
