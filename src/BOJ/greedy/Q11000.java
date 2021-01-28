/*
 * Q11000.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q11000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Queue<Integer[]> courses = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        });

        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            courses.add(new Integer[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        if(n == 1){
            System.out.println(1);
            return;
        }

        Queue<Integer> list = new PriorityQueue<>(Comparator.reverseOrder());
        Integer[] course = courses.poll();
        list.add(course[0]);
        while(!courses.isEmpty()){
            course = courses.poll();
            if(course[1] <= list.peek()){
                list.poll();
                list.add(course[0]);
            }
            else{
                list.add(course[0]);
            }
        }

        System.out.println(list.size());
    }
}
