/*
 * q1920.java
 * Author : 박찬형
 * Created Date : 2021-10-12
 */
package BOJ;

import java.io.*;
import java.util.Arrays;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];
        input = br.readLine().split(" ");
        for(int i = 0; i < check.length; i++){
            check[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);
        for(int i = 0; i < check.length; i++){
            if(check(check[i], arr)){
                check[i] = 1;
            }
            else{
                check[i] = 0;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int c : check){
            bw.write(String.valueOf(c) + '\n');
        }
        bw.close();
    }

    static boolean check(int num, int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == num){
                return true;
            }
            else if(arr[mid] > num){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }

        return arr[end] == num;
    }
}
