/*
 * Q14502.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.*;

public class Q14502 {
    static int[][] graph;
    static int[][] copy;
    static List<Integer[]> startPoints = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];
        for(int i = 0; i < height; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < width; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if(graph[i][j] == 2){
                    startPoints.add(new Integer[]{j, i});
                }
            }
        }

        makeWall(0, 0, 0);
        System.out.println(max);
    }

    static void makeWall(int x, int y, int count){
        if(count == 3){
            spread();
            return;
        }
        if(y >= graph.length){
            return;
        }
        if(x >= graph[0].length){
           makeWall(0, y + 1, count);
           return;
        }
        if(graph[y][x] == 0){
            graph[y][x] = 1;
            makeWall(x + 1, y, count + 1);
            graph[y][x] = 0;
        }
        makeWall(x + 1, y, count);
    }

    static void copy(){
        copy = new int[graph.length][graph[0].length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                copy[i][j] = graph[i][j];
            }
        }
    }

    static void spread(){
        copy();
        Queue<Integer[]> queue = new LinkedList<>();
        queue.addAll(startPoints);
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            if(check(cur[0] + 1, cur[1])){
                queue.add(new Integer[]{cur[0] + 1, cur[1]});
                copy[cur[1]][cur[0] + 1] = 2;
            }
            if(check(cur[0] - 1, cur[1])){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                copy[cur[1]][cur[0] - 1] = 2;
            }
            if(check(cur[0], cur[1] + 1)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                copy[cur[1] + 1][cur[0]] = 2;
            }
            if(check(cur[0], cur[1] - 1)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                copy[cur[1] - 1][cur[0]] = 2;
            }

        }

        int safe = getSafe();
        if(safe > max){
            max = safe;
        }
    }

    static boolean check(int x, int y){
        if(x < 0 || x >= copy[0].length || y < 0 || y >= copy.length){
            return false;
        }
        return copy[y][x] == 0;
    }

    static int getSafe(){
        int safe = 0;
        for(int i = 0; i < copy.length; i++){
            for(int j = 0; j < copy[0].length; j++){
                if(copy[i][j] == 0){
                    safe++;
                }
            }
        }
        return safe;
    }
}
