/*
 * Q5014.java
 * Author : 박찬형
 * Created Date : 2021-02-09
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
    static int[] building;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int F = scanner.nextInt();
        building = new int[F];
        visited = new boolean[F];
        int S = scanner.nextInt() - 1;
        int G = scanner.nextInt() - 1;
        int U = scanner.nextInt();
        int D = scanner.nextInt();

        int result = visit(S, G, U, D);
        if(result == -1){
            System.out.println("use the stairs");
            return;
        }
        System.out.println(result);
    }

    static int visit(int start, int end, int up, int down){
        if(start == end){
            return 0;
        }
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;
        int next = 0;
        while(!queue.isEmpty()){
            while(count != 0){
                int cur = queue.poll();
                if(check(cur + up)){
                    queue.add(cur + up);
                    visited[cur + up] = true;
                    next++;
                }
                if(check(cur - down)){
                    queue.add(cur - down);
                    visited[cur - down] = true;
                    next++;
                }
                count--;
            }
            time++;
            if(visited[end]){
                return time;
            }
            count = next;
            next = 0;
        }

        return -1;
    }

    static boolean check(int i){
        if(i < 0 || i >= building.length){
            return false;
        }
        return !visited[i];
    }
}
