/*
 * Q21317.java
 * Author : 박찬형
 * Created Date : 2021-10-12
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N - 1][];
        String[] input;
        for(int i = 0; i < costs.length; i++){
            input = br.readLine().split(" ");
            costs[i] = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];

        for(int i = 0; i < dp.length - 1; i++){
            if(dp[i + 1][0] == 0 || dp[i][0] + costs[i][0] < dp[i + 1][0]){
                dp[i + 1][0] = dp[i][0] + costs[i][0];
            }
            if(i + 2 < dp.length && (dp[i + 2][0] == 0 || dp[i][0] + costs[i][1] < dp[i + 2][0])){
                dp[i + 2][0] = dp[i][0] + costs[i][1];
            }
            if(i + 3 < dp.length && (dp[i + 3][1] == 0 || dp[i][0] + K < dp[i + 3][1])){
                dp[i + 3][1] = dp[i][0] + K;
            }

            if(dp[i][1] != 0){
                if(dp[i + 1][1] == 0 || dp[i][1] + costs[i][0] < dp[i + 1][1]){
                    dp[i + 1][1] = dp[i][1] + costs[i][0];
                }
                if(i + 2 < dp.length && (dp[i + 2][1] == 0 || dp[i][1] + costs[i][1] < dp[i + 2][1])){
                    dp[i + 2][1] = dp[i][1] + costs[i][1];
                }
            }
        }

        if(dp[dp.length - 1][0] == 0){
            System.out.println(dp[dp.length - 1][1]);
        }
        else if(dp[dp.length - 1][1] == 0){
            System.out.println(dp[dp.length - 1][0]);
        }
        else{
            System.out.println(Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]));
        }
    }
}
