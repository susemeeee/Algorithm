/*
 * Q2579.java
 * Author : 박찬형
 * Created Date : 2021-02-18
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {
    static int[] scores;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int stairs = Integer.parseInt(bf.readLine());
        scores = new int[stairs];
        results = new int[stairs];
        for(int i = 0; i < stairs; i++){
            scores[i] = Integer.parseInt(bf.readLine());
        }
        results[0] = scores[0];
        if(stairs > 1){
            results[1] = scores[1] + scores[0];
        }
        if(stairs > 2){
            results[2] = Math.max(scores[2] + scores[0], scores[2] + scores[1]);
        }

        for(int i = 3; i < stairs; i++){
            results[i] = Math.max(scores[i - 1] + results[i - 3], results[i - 2]) + scores[i];
        }

        System.out.println(results[stairs - 1]);
    }
}
