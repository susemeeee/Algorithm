/*
 * Q2468.java
 * Author : 박찬형
 * Created Date : 2021-02-02
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2468 {
    static int[][] graph;
    static int[][] copy;
    static int min = 101;
    static int max = 1;
    static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                int element = Integer.parseInt(input[j]);
                graph[i][j] = element;
                if(element < min){
                    min = element;
                }
                if(element > max){
                    max = element;
                }
            }
        }

        for(int i = min; i <= max; i++){
            int newCount = rain(i);
            if(newCount > count){
                count = newCount;
            }
        }

        System.out.println(count);
    }

    static int rain(int water){
        copy = new int[graph.length][graph.length];
        copy(water);
        int count = 0;
        for(int i = 0; i < copy.length; i++){
            for(int j = 0; j < copy.length; j++){
                if(copy[i][j] != 0){
                    visit(j, i);
                    count++;
                }
            }
        }

        return count;
    }

    static void visit(int x, int y){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        copy[y][x] = 0;
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            if(check(cur[0] + 1, cur[1])){
                queue.add(new Integer[]{cur[0] + 1, cur[1]});
                copy[cur[1]][cur[0] + 1] = 0;
            }
            if(check(cur[0] - 1, cur[1])){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                copy[cur[1]][cur[0] - 1] = 0;
            }
            if(check(cur[0], cur[1] + 1)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                copy[cur[1] + 1][cur[0]] = 0;
            }
            if(check(cur[0], cur[1] - 1)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                copy[cur[1] - 1][cur[0]] = 0;
            }
        }
    }

    static void copy(int water){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(graph[i][j] > water){
                    copy[i][j] = graph[i][j];
                }
            }
        }
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= copy.length || y >= copy.length){
            return false;
        }
        return copy[y][x] != 0;
    }
}
