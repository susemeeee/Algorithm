/*
 * Q10844.java
 * Author : 박찬형
 * Created Date : 2021-02-27
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n][10];
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = 1;
        }

        final int MOD = 1000000000;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j > 0){
                    dp[i][j - 1] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
                if(j < 9){
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % MOD;
                }
            }
        }

        int sum = 0;
        for(int i : dp[n - 1]){
            sum = (sum + i) % MOD;
        }

        System.out.println(sum % MOD);
    }
}
