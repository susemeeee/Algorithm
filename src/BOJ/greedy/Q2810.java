/*
 * Q2810.java
 * Author : 박찬형
 * Created Date : 2021-01-22
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q2810 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String seat = scanner.nextLine();

        if(n == 1){
            System.out.println(1);
            return;
        }
        if(seat.indexOf('L') == -1){
            System.out.println(n);
            return;
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(seat.charAt(i) == 'L'){
                i++;
            }
            count++;
        }
        count++;

        System.out.println(count);
    }
}
