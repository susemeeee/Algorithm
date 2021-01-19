/*
 * Q1715.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.*;

public class Q1715 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //List<Integer> cards = new ArrayList<>();
        Queue<Integer> cards = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            cards.add(scanner.nextInt());
        }

        if(n == 1){
            System.out.println(0);
            return;
        }

        int sum = 0;

        while(cards.size() > 1){
            int n1 = cards.poll();
            int n2 = cards.poll();

            sum += n1 + n2;
            cards.add(n1 + n2);
        }

        System.out.println(sum);
    }
}
