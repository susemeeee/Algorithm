/*
 * Q2667.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q2667 {
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Integer> counts = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    counts.add(visit(n, j, i));
                }
            }
        }

        System.out.println(counts.size());
        while(!counts.isEmpty()){
            System.out.println(counts.poll());
        }
    }

    static int visit(int n, int x, int y){
        Queue<Integer[]> visit = new LinkedList<>();
        visit.add(new Integer[]{x, y});
        graph[y][x] = 0;
        visited[y][x] = true;
        int count = 1;
        while(!visit.isEmpty()){
            Integer[] cur = visit.poll();
            if(check(cur[0] + 1, cur[1])){
                visit.add(new Integer[]{cur[0] + 1, cur[1]});
                visited[cur[1]][cur[0] + 1] = true;
                graph[cur[1]][cur[0] + 1] = 0;
                count++;
            }
            if(check(cur[0], cur[1] + 1)){
                visit.add(new Integer[]{cur[0], cur[1] + 1});
                visited[cur[1] + 1][cur[0]] = true;
                graph[cur[1] + 1][cur[0]] = 0;
                count++;
            }
            if(check(cur[0], cur[1] - 1)){
                visit.add(new Integer[]{cur[0], cur[1] - 1});
                visited[cur[1] - 1][cur[0]] = true;
                graph[cur[1] - 1][cur[0]] = 0;
                count++;
            }
            if(check(cur[0] - 1, cur[1])){
                visit.add(new Integer[]{cur[0] - 1, cur[1]});
                visited[cur[1]][cur[0] - 1] = true;
                graph[cur[1]][cur[0] - 1] = 0;
                count++;
            }
        }

        return count;
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        if(visited[y][x]){
            return false;
        }
        if(graph[y][x] == 0){
            return false;
        }
        return true;
    }
}
