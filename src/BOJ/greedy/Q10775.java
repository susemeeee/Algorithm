/*
 * Q10775.java
 * Author : 박찬형
 * Created Date : 2021-01-22
 */
package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(bufferedReader.readLine());
        int p = Integer.parseInt(bufferedReader.readLine());
        int[] gates = new int[g + 1];

        for(int i = 0; i < gates.length; i++){
            gates[i] = i;
        }

        int count = 0;
        for(int i = 0; i < p; i++){
            int cur = find(Integer.parseInt(bufferedReader.readLine()), gates);
            if(cur == 0){
                break;
            }
            count++;
            gates = union(cur, cur - 1, gates);
        }

        System.out.println(count);
    }

    static int[] union(int n, int m, int[] arr){
        n = find(n, arr);
        m = find(m, arr);

        arr[n] = m;

        return arr;
    }

    static int find(int n, int[] arr){
        if(arr[n] == n){
            return n;
        }
        return arr[n] = find(arr[n], arr);
    }
}
