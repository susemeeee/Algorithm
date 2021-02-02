/*
 * Q10026.java
 * Author : 박찬형
 * Created Date : 2021-02-03
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10026 {
    static int[][] graph;
    static int[][] copy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < n; j++){
                char element = input.charAt(j);
                if(element == 'R'){
                    graph[i][j] = 1;
                }
                else if(element == 'G'){
                    graph[i][j] = 2;
                }
                else if(element == 'B'){
                    graph[i][j] = 3;
                }
            }
        }

        copyGraph();
        int count = 0;
        int penaltyCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(copy[i][j] != -1){
                    visit(j, i, false);
                    count++;
                }

            }
        }
        copyGraph();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(copy[i][j] != -1){
                    visit(j, i, true);
                    penaltyCount++;
                }
            }
        }

        System.out.println(count + " " + penaltyCount);
    }

    static void copyGraph(){
        copy = new int[graph.length][graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                copy[i][j] = graph[i][j];
            }
        }
    }

    static void visit(int x, int y, boolean penalty){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        int prev = copy[y][x];
        copy[y][x] = -1;
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            if(check(cur[0] - 1, cur[1], prev, penalty)){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                copy[cur[1]][cur[0] - 1] = -1;
            }
            if(check(cur[0] + 1, cur[1], prev, penalty)){
                queue.add(new Integer[]{cur[0] + 1, cur[1]});
                copy[cur[1]][cur[0] + 1] = -1;
            }
            if(check(cur[0], cur[1] - 1, prev, penalty)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                copy[cur[1] - 1][cur[0]] = -1;
            }
            if(check(cur[0], cur[1] + 1, prev, penalty)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                copy[cur[1] + 1][cur[0]] = -1;
            }
        }
    }

    static boolean check(int x, int y, int prev, boolean penalty){
        if(x < 0 || y < 0 || x >= copy[0].length || y >= copy.length){
            return false;
        }
        if(penalty && (prev == 1 || prev == 2)){
            return copy[y][x] == 1 || copy[y][x] == 2;
        }
        else{
            return copy[y][x] == prev;
        }
    }
}
