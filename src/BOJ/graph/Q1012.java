/*
 * Q1012.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1012 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] graph;

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < tests; i++){
            test();
        }
    }

    static void test(){
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];

        for(int i = 0; i < k; i++){
            String[] input = scanner.nextLine().split(" ");
            graph[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
        }

        int count = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(graph[i][j] == 1){
                    visit(j, i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void visit(int x, int y){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        graph[y][x] = 0;
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            if(check(cur[0] + 1, cur[1])){
                queue.add(new Integer[]{cur[0] + 1, cur[1]});
                graph[cur[1]][cur[0] + 1] = 0;
            }
            if(check(cur[0] - 1, cur[1])){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                graph[cur[1]][cur[0] - 1] = 0;
            }
            if(check(cur[0], cur[1] + 1)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                graph[cur[1] + 1][cur[0]] = 0;
            }
            if(check(cur[0], cur[1] - 1)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                graph[cur[1] - 1][cur[0]] = 0;
            }
        }
    }

    static boolean check(int x, int y){
        if(x < 0 || x >= graph[0].length || y < 0 || y >= graph.length){
            return false;
        }
        return graph[y][x] == 1;
    }
}
