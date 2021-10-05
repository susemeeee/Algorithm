/*
 * Q14501.java
 * Author : 박찬형
 * Created Date : 2021-10-05
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            data[i][0] = Integer.parseInt(input[0]);
            data[i][1] = Integer.parseInt(input[1]);
        }
        int[] dp = new int[N];
        if(data[N - 1][0] - 1 + (N - 1) >= N){
            dp[N - 1] = 0;
        }
        else{
            dp[N - 1] = data[N - 1][1];
        }

        for(int i = N - 2; i >= 0; i--){
            dp[i] = dp[i + 1];
            int nextDay = i + data[i][0] - 1;
            if(nextDay >= N){
                continue;
            }

            nextDay++;
            dp[i] = Math.max(dp[i], (nextDay < N ? dp[nextDay] : 0) + data[i][1]);
        }

        System.out.println(dp[0]);
    }
}
