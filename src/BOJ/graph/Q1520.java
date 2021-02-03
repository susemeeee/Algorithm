/*
 * Q1520.java
 * Author : 박찬형
 * Created Date : 2021-02-03
 */
package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1520 {
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        graph = new int[height][width];
        visited = new int[height][width];
        for(int i = 0; i < height; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < width; j++){
                graph[i][j] = Integer.parseInt(input[j]);
                visited[i][j] = -1;
            }
        }

        System.out.println(visit(0, 0));
    }

    static int visit(int x, int y){
        if(x == graph[0].length - 1 && y == graph.length - 1){
            visited[graph.length - 1][graph[0].length - 1] = 1;
            return 1;
        }

        int sum = 0;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(check(nextX, nextY, graph[y][x])){
                if(visited[nextY][nextX] == -1){
                    sum += visit(nextX, nextY);
                }
                else{
                    sum += visited[nextY][nextX];
                }
            }
        }

        visited[y][x] = sum;
        return sum;
    }

    static boolean check(int x, int y, int prev){
        if(x < 0 || x >= graph[0].length || y < 0 || y >= graph.length){
            return false;
        }
        return graph[y][x] < prev;
    }
}
