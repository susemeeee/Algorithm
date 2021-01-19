/*
 * Q1783.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q1783 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int[] chess = {x, y};

        if(chess[0] == 1){
            System.out.println(1);
            return;
        }
        if(chess[0] == 2){
            int move = 0;
            int i = 1;
            while(i <= chess[1]){
                i += 2;
                if(i <= chess[1]){
                    move++;
                }
                if(move == 3){
                    break;
                }
            }
            System.out.println(move + 1);
            return;
        }

        if(chess[1] >= 4 && chess[1] < 7){
            System.out.println(4);
            return;
        }
        else if(chess[1] < 4){
            System.out.println(chess[1]);
            return;
        }

        System.out.println(chess[1] - 2);
    }
}
