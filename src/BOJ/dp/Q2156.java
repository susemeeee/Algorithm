/*
 * Q2156.java
 * Author : 박찬형
 * Created Date : 2021-02-22
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
    static int[] values;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        values = new int[n];
        results = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = Integer.parseInt(bf.readLine());
            results[i] = -1;
        }

        results[0] = values[0];
        if(n == 1){
            System.out.println(results[0]);
            return;
        }
        results[1] = values[0] + values[1];
        if(n == 2){
            System.out.println(results[1]);
            return;
        }
        results[2] = Math.max(Math.max(values[1] + values[2], values[0] + values[2])
                , values[0] + values[1]);
        if(n == 3){
            System.out.println(results[2]);
            return;
        }

        System.out.println(getResult(n));
    }

    static int getResult(int n){
        if(n > 3 && results[n - 1] == -1){
            results[n - 1] = Math.max(Math.max(getResult(n - 2),
                    getResult(n - 3) + values[n - 2]) + values[n - 1],
                    getResult(n - 1));
        }

        return results[n - 1];
    }
}
