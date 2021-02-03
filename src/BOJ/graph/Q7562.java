/*
 * Q7562.java
 * Author : 박찬형
 * Created Date : 2021-02-03
 */
package BOJ.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] graph;
    static int[] results;

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        results = new int[tests];
        for(int i = 0; i < tests; i++){
            test(i);
        }

        for(int i = 0; i < tests; i++){
            System.out.println(results[i]);
        }
    }

    static void test(int i){
        int length = scanner.nextInt();
        graph = new int[length][length];
        Integer[] start = new Integer[]{scanner.nextInt(), scanner.nextInt()};
        Integer[] end = new Integer[]{scanner.nextInt(), scanner.nextInt()};
        if(start[0].compareTo(end[0]) == 0 && start[1].compareTo(end[1]) == 0){
            results[i] = 0;
            return;
        }
        results[i] = visit(start, end);
    }

    static int visit(Integer[] start, Integer[] end){
        Queue<Integer[]> queue = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();
        queue.add(start);
        graph[start[1]][start[0]] = -1;
        int move = 0;
        int count = 1;
        int nextCount = 0;
        while(!queue.isEmpty()){
            if(count == 0){
                counts.add(nextCount);
                nextCount = 0;
                count = counts.poll();
                move++;
            }
            Integer[] cur = queue.poll();
            count--;
            if(check(cur[0] - 2, cur[1] - 1)){
                queue.add(new Integer[]{cur[0] - 2, cur[1] - 1});
                graph[cur[1] - 1][cur[0] - 2] = -1;
                nextCount++;
            }
            if(check(cur[0] - 1, cur[1] - 2)){
                queue.add(new Integer[]{cur[0] - 1, cur[1] - 2});
                graph[cur[1] - 2][cur[0] - 1] = -1;
                nextCount++;
            }

            if(check(cur[0] + 2, cur[1] - 1)){
                queue.add(new Integer[]{cur[0] + 2, cur[1] - 1});
                graph[cur[1] - 1][cur[0] + 2] = -1;
                nextCount++;
            }
            if(check(cur[0] + 1, cur[1] - 2)){
                queue.add(new Integer[]{cur[0] + 1, cur[1] - 2});
                graph[cur[1] - 2][cur[0] + 1] = -1;
                nextCount++;
            }

            if(check(cur[0] - 2, cur[1] + 1)){
                queue.add(new Integer[]{cur[0] - 2, cur[1] + 1});
                graph[cur[1] + 1][cur[0] - 2] = -1;
                nextCount++;
            }
            if(check(cur[0] - 1, cur[1] + 2)){
                queue.add(new Integer[]{cur[0] - 1, cur[1] + 2});
                graph[cur[1] + 2][cur[0] - 1] = -1;
                nextCount++;
            }

            if(check(cur[0] + 2, cur[1] + 1)){
                queue.add(new Integer[]{cur[0] + 2, cur[1] + 1});
                graph[cur[1] + 1][cur[0] + 2] = -1;
                nextCount++;
            }
            if(check(cur[0] + 1, cur[1] + 2)){
                queue.add(new Integer[]{cur[0] + 1, cur[1] + 2});
                graph[cur[1] + 2][cur[0] + 1] = -1;
                nextCount++;
            }
            if(graph[end[1]][end[0]] == -1){
                break;
            }
        }

        return move + 1;
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= graph.length || y >= graph.length){
            return false;
        }
        return graph[y][x] != -1;
    }
}
