/*
 * Q13305.java
 * Author : 박찬형
 * Created Date : 2021-01-20
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q13305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] roads = new int[n - 1];
        int[] cities = new int[n];

        String[] input = scanner.nextLine().split(" ");
        for(int i = 0; i < n - 1; i++){
            roads[i] = Integer.parseInt(input[i]);
        }

        input = scanner.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            cities[i] = Integer.parseInt(input[i]);
        }

        long cost = 0;
        int prev = cities[0];
        for(int i = 0; i < n - 1; i++){
            if(cities[i] < prev){
                prev = cities[i];
            }

            cost += ((long)prev * roads[i]);
        }

        System.out.println(cost);
    }
}
