/*
 * Q1463.java
 * Author : 박찬형
 * Created Date : 2021-02-13
 */
package BOJ.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1463 {
    static int[] results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        results = new int[X + 1];
        results[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            if(results[X] != 0){
                break;
            }
            int cur = queue.poll();
            if(check(X, cur + 1)){
                results[cur + 1] = results[cur] + 1;
                queue.add(cur + 1);
            }
            if(check(X, cur * 2)){
                results[cur * 2] = results[cur] + 1;
                queue.add(cur * 2);
            }
            if(check(X, cur * 3)){
                results[cur * 3] = results[cur] + 1;
                queue.add(cur * 3);
            }
        }

        System.out.println(results[X]);
    }

    static boolean check(int X, int next){
        return next <= X && results[next] == 0;
    }
}
