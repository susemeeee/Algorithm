/*
 * Q5585.java
 * Author : 박찬형
 * Created Date : 2021-01-15
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q5585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = 1000 - scanner.nextInt();

        int count = 0;

        while(price != 0){
            if(price >= 500){
                price -= 500;
            }
            else if(price >= 100){
                price -= 100;
            }
            else if(price >= 50){
                price -= 50;
            }
            else if(price >= 10){
                price -= 10;
            }
            else if(price >= 5){
                price -= 5;
            }
            else{
                price--;
            }

            count++;
        }

        System.out.println(count);
    }
}
