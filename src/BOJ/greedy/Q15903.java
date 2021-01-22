/*
 * Q15903.java
 * Author : 박찬형
 * Created Date : 2021-01-22
 */
package BOJ.greedy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q15903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = scanner.nextLine().split(" ");
        Queue<Long> cards = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            cards.add(Long.parseLong(input[i]));
        }

        long score = 0;
        for(int i = 0; i < m; i++){
            long card1 = cards.poll();
            long card2 = cards.poll();

            cards.add(card1 + card2);
            cards.add(card1 + card2);
        }


        while(!cards.isEmpty()){
            score += cards.poll();
        }

        System.out.println(score);
    }
}
