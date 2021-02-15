/*
 * Q1003.java
 * Author : 박찬형
 * Created Date : 2021-02-15
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    static int[] zeroCounts = new int[41];
    static int[] oneCounts = new int[41];
    static boolean[] counted = new boolean[41];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bf.readLine());
        zeroCounts[0] = 1;
        zeroCounts[1] = 0;
        oneCounts[0] = 0;
        oneCounts[1] = 1;
        counted[0] = true;
        counted[1] = true;
        for(int i = 0; i < tests; i++){
            int cur = Integer.parseInt(bf.readLine());
            int[] result;
            if(!counted[cur]){
                result = fibonacci(cur);
                zeroCounts[cur] = result[0];
                oneCounts[cur] = result[1];
                counted[cur] = true;
            }
            else{
                result = new int[]{zeroCounts[cur], oneCounts[cur]};
            }
            System.out.println(result[0] + " " + result[1]);
        }
    }

    static int[] fibonacci(int n) {
        if (n == 0) {
            return new int[]{1, 0};
        }
        else if (n == 1) {
            return new int[]{0, 1};
        }
        else {
            int[] result1;
            int[] result2;
            if(!counted[n - 1]){
                result1 = fibonacci(n - 1);
                counted[n - 1] = true;
                zeroCounts[n - 1] = result1[0];
                oneCounts[n - 1] = result1[1];
            }
            else{
                result1 = new int[]{zeroCounts[n - 1], oneCounts[n - 1]};
            }
            if(!counted[n - 2]){
                result2 = fibonacci(n - 1);
                counted[n - 2] = true;
                zeroCounts[n - 2] = result2[0];
                oneCounts[n - 2] = result2[1];
            }
            else{
                result2 = new int[]{zeroCounts[n - 2], oneCounts[n - 2]};
            }
            return new int[]{result1[0] + result2[0], result1[1] + result2[1]};
        }
    }
}
