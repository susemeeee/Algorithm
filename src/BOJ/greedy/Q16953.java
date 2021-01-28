/*
 * Q16953.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q16953 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int count = 0;
        while(b > a){
            if(b % 10 == 1){
                b /= 10;
                count++;
            }
            else if(b % 2 == 0){
                b /= 2;
                count++;
            }
            else{
                System.out.println(-1);
                return;
            }


        }
        if(b == a){
            System.out.println(count + 1);
            return;
        }
        System.out.println(-1);
    }
}
