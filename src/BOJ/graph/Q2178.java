/*
 * Q2178.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                visited[i][j] = false;
            }
        }
        visit();
        System.out.println(graph[n - 1][m - 1]);
    }

    static void visit(){
        Queue<Integer[]> visit = new LinkedList<>();
        visit.add(new Integer[]{0, 0});
        while(!visit.isEmpty()){
            Integer[] cur = visit.poll();
            if(check(cur[0] + 1, cur[1])){
                visit.add(new Integer[]{cur[0] + 1, cur[1]});
                visited[cur[1]][cur[0] + 1] = true;
                graph[cur[1]][cur[0] + 1] += graph[cur[1]][cur[0]];
            }
            if(check(cur[0], cur[1] + 1)){
                visit.add(new Integer[]{cur[0], cur[1] + 1});
                visited[cur[1] + 1][cur[0]] = true;
                graph[cur[1] + 1][cur[0]] += graph[cur[1]][cur[0]];
            }
            if(check(cur[0], cur[1] - 1)){
                visit.add(new Integer[]{cur[0], cur[1] - 1});
                visited[cur[1] - 1][cur[0]] = true;
                graph[cur[1] - 1][cur[0]] += graph[cur[1]][cur[0]];
            }
            if(check(cur[0] - 1, cur[1])){
                visit.add(new Integer[]{cur[0] - 1, cur[1]});
                visited[cur[1]][cur[0] - 1] = true;
                graph[cur[1]][cur[0] - 1] += graph[cur[1]][cur[0]];
            }
        }
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
