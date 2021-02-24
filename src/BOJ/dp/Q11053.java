/*
 * Q11053.java
 * Author : 박찬형
 * Created Date : 2021-02-24
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11053 {
    static int[] array;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(bf.readLine());
        array = new int[n];
        results = new int[n];
        String[] input = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(input[i]);
        }

        for(int i = n - 1; i >= 0; i--) {
            if(results[i] == 0){
                results[i] = count(i);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            if(results[i] > max){
                max = results[i];
            }
        }

        System.out.println(max);
    }

    static int count(int cur){
        if(results[cur] == 0){
            results[cur] = 1;
        }

        if(cur == array.length - 1){
            return results[cur];
        }

        for(int i = cur + 1; i < array.length; i++){
            if(array[i] > array[cur]){
                int result;
                if(results[i] == 0){
                    result = count(i);
                }
                else{
                    result = results[i];
                }
                results[cur] = Math.max(result + 1, results[cur]);
            }
        }

        return results[cur];
    }
}
