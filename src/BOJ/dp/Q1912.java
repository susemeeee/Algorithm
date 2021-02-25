/*
 * Q1912.java
 * Author : 박찬형
 * Created Date : 2021-02-25
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1912 {
    static int[] arr;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        results = new int[n];
        String[] input = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i = n - 1; i >= 0; i--){
            if(results[i] == 0) {
                results[i] = dp(i);
            }
        }

        int max = results[0];
        for(int i = 1; i < n; i++){
            if(results[i] > max){
                max = results[i];
            }
        }

        System.out.println(max);
    }

    static int dp(int cur){
        if(results[cur] == 0){
            results[cur] = arr[cur];
        }
        if(cur == arr.length - 1){
            return results[cur];
        }

        int result = arr[cur];
        if(results[cur + 1] != 0){
            result += results[cur + 1];
        }
        else{
            result += dp(cur + 1);
        }
        results[cur] = Math.max(results[cur], result);

        return results[cur];
    }
}
