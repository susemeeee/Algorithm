/*
 * Q4963.java
 * Author : 박찬형
 * Created Date : 2021-01-31
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4963 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] graph;

    public static void main(String[] args) {
        while(true){
            String[] input = scanner.nextLine().split(" ");
            if(input[0].equals("0") && input[1].equals("0")){
                break;
            }
            test(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    static void test(int width, int height){
        graph = new int[height][width];
        for(int i = 0; i < height; i++){
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < width; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
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
            if(check(cur[0], cur[1] + 1)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                graph[cur[1] + 1][cur[0]] = 0;
            }
            if(check(cur[0], cur[1] - 1)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                graph[cur[1] - 1][cur[0]] = 0;
            }
            if(check(cur[0] - 1, cur[1])){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                graph[cur[1]][cur[0] - 1] = 0;
            }

            if(check(cur[0] + 1, cur[1] + 1)){
                queue.add(new Integer[]{cur[0] + 1, cur[1] + 1});
                graph[cur[1] + 1][cur[0] + 1] = 0;
            }
            if(check(cur[0] + 1, cur[1] - 1)){
                queue.add(new Integer[]{cur[0] + 1, cur[1] - 1});
                graph[cur[1] - 1][cur[0] + 1] = 0;
            }
            if(check(cur[0] - 1, cur[1] + 1)){
                queue.add(new Integer[]{cur[0] - 1, cur[1] + 1});
                graph[cur[1] + 1][cur[0] - 1] = 0;
            }
            if(check(cur[0] - 1, cur[1] - 1)){
                queue.add(new Integer[]{cur[0] - 1, cur[1] - 1});
                graph[cur[1] - 1][cur[0] - 1] = 0;
            }
        }
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        if(graph[y][x] == 0){
            return false;
        }
        return true;
    }
}
