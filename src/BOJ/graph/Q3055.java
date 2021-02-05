/*
 * Q3055.java
 * Author : 박찬형
 * Created Date : 2021-02-05
 */
package BOJ.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3055 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] start;
    static Queue<int[]> waterStartPoints = new LinkedList<>();
    static int[] end;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];
        visited = new boolean[height][width];
        for(int i = 0; i < height; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < width; j++){
                int value;
                if(input.charAt(j) == '.'){
                    value = 0;
                }
                else if(input.charAt(j) == 'D'){
                    value = 3;
                    end = new int[]{j, i};
                }
                else if(input.charAt(j) == '*'){
                    value = 2;
                    waterStartPoints.add(new int[]{j, i});
                }
                else if(input.charAt(j) == 'S'){
                    value = 1;
                    start = new int[]{j, i};
                }
                else{
                    value = -1;
                }
                graph[i][j] = value;
            }
        }

        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> waterQueue = new LinkedList<>();
        int waterCount = waterStartPoints.size();
        while(!waterStartPoints.isEmpty()){
            waterQueue.add(waterStartPoints.poll());
        }
        queue.add(start);
        visited[start[1]][start[0]] = true;//?
        int time = 0;
        int count = 1;
        int nextCount = 0;
        boolean failed = true;
        while(!queue.isEmpty()){
            if(count == 0){
                count = nextCount;
                nextCount = 0;
                time++;
                Queue<int[]> newWaterQueue = new LinkedList<>();
                while(!waterQueue.isEmpty()){
                    int[] curWater = waterQueue.poll();
                    for(int i = 0; i < 4; i++){
                        int nextX = curWater[0] + dx[i];
                        int nextY = curWater[1] + dy[i];
                        if(waterCheck(nextX, nextY)){
                            graph[nextY][nextX] = 2;
                            newWaterQueue.add(new int[]{nextX, nextY});
                        }
                    }
                }
                while(!newWaterQueue.isEmpty()){
                    waterQueue.add(newWaterQueue.poll());
                }
            }
            int[] cur = queue.poll();

            count--;
            if(cur[0] == end[0] && cur[1] == end[1]){
                failed = false;
                break;
            }
            failed = true;
            if(graph[cur[1]][cur[0]] != 2){
                for(int i = 0; i < 4; i++){
                    int nextX = cur[0] + dx[i];
                    int nextY = cur[1] + dy[i];
                    if(check(nextX, nextY)){
                        failed = false;
                        if(graph[nextY][nextX] != 3){
                            graph[nextY][nextX] = 1;
                        }
                        nextCount++;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        if(failed){
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(time);
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        return graph[y][x] == 0 || graph[y][x] == 3;
    }

    static boolean waterCheck(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        return graph[y][x] == 1 || graph[y][x] == 0;
    }
}
