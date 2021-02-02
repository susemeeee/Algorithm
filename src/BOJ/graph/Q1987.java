/*
 * Q1987.java
 * Author : 박찬형
 * Created Date : 2021-02-02
 */
package BOJ.graph;

import java.util.Scanner;

public class Q1987 {
    static char[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        graph = new char[height][width];
        for(int i = 0; i < height; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < width; j++){
                graph[i][j] = input.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[graph[0][0] - 'A'] = true;
        System.out.println(visit(0, 0, visited));
    }

    static int visit(int x, int y, boolean[] visited){
        int[] counts = new int[]{0, 0, 0, 0};
        if(check(x - 1, y, visited)){
            boolean[] newVisited = visited.clone();
            newVisited[graph[y][x - 1] - 'A'] = true;
            counts[0] = visit(x - 1, y, newVisited);
        }
        if(check(x + 1, y, visited)){
            boolean[] newVisited = visited.clone();
            newVisited[graph[y][x + 1] - 'A'] = true;
            counts[1] = visit(x + 1, y, newVisited);
        }
        if(check(x, y - 1, visited)){
            boolean[] newVisited = visited.clone();
            newVisited[graph[y - 1][x] - 'A'] = true;
            counts[2] = visit(x, y - 1, newVisited);
        }
        if(check(x, y + 1, visited)){
            boolean[] newVisited = visited.clone();
            newVisited[graph[y + 1][x] - 'A'] = true;
            counts[3] = visit(x, y + 1, newVisited);
        }

        int max1 = Math.max(counts[0], counts[1]);
        int max2 = Math.max(counts[2], counts[3]);

        return Math.max(max1, max2) + 1;
    }

    static boolean check(int x, int y, boolean[] visited){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        return !visited[graph[y][x] - 'A'];
    }
}
