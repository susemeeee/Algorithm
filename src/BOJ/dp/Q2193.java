/*
 * Q2193.java
 * Author : 박찬형
 * Created Date : 2021-02-23
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] results = new long[n];
        if(n <= 2){
            System.out.println(1);
            return;
        }
        results[0] = 1;
        results[1] = 1;
        for(int i = 2; i < n; i++){
            results[i] = results[i - 2] + results[i - 1];
        }

        System.out.println(results[n - 1]);
    }
}
