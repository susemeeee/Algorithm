/*
 * Q11047.java
 * Author : 박찬형
 * Created Date : 2021-01-14
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
        }

        int index = n - 1;
        int count = 0;

        while(k != 0){
            if(k >= coins[index]){
                k -= coins[index];
                count++;
            }
            else{
                index--;
            }
        }

        System.out.println(count);
    }
}
