/*
 * Q2573.java
 * Author : 박찬형
 * Created Date : 2021-02-06
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2573 {
    static int[][] graph;
    static int[][] around;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] copy;
    static Queue<int[]> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];
        around = new int[height][width];
        for(int i = 0; i < height; i++){
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < width; j++){
                int value = Integer.parseInt(input[j]);
                if(value != 0){
                    queue.add(new int[]{j, i});
                    queue2.add(new int[]{j, i});
                }
                graph[i][j] = value;
            }
        }
        int size = queue2.size();
        for(int i = 0; i < size; i++){
            int[] cur = queue2.poll();
            around[cur[1]][cur[0]] = findAround(cur[0], cur[1]);
        }
        System.out.println(start());
    }

    static int findAround(int x, int y){
        int count = 0;
        for(int i = 0; i < 4; i++){
            if(graph[y + dy[i]][x + dx[i]] <= 0){
                count++;
            }
        }
        return count;
    }

    static int start(){
        queue2 = new LinkedList<>();
        int time = 0;
        int count = queue.size();
        copy();
        int[] test = queue.peek();
        if(bfs(test[0], test[1]) < queue.size()){
            return 0;
        }
        int prevCount = count;
        while(!queue.isEmpty()){
            while(count != 0){
                int[] cur = queue.poll();
                graph[cur[1]][cur[0]] -= around[cur[1]][cur[0]];
                if(graph[cur[1]][cur[0]] > 0){
                    queue.add(cur);
                }
                else{
                    queue2.add(cur);
                }
                count--;
            }
            if(queue.isEmpty()){
                break;
            }
            count = queue.size();
            time++;
            if(count < prevCount){
                copy();
                test = queue.peek();
                int result = bfs(test[0], test[1]);
                if(result < queue.size()){
                    return time;
                }
            }
            prevCount = count;
            while(!queue2.isEmpty()){
                int[] cur = queue2.poll();
                for(int i = 0; i < 4; i++){
                    if(checkAround(cur[0] + dx[i], cur[1] + dy[i])){
                        around[cur[1] + dy[i]][cur[0] + dx[i]]++;
                    }
                }
            }
        }

        return 0;
    }

    static void copy(){
        copy = new int[graph.length][graph[0].length];
        for(int i = 1; i < graph.length - 1; i++){
            for(int j = 1; j < graph[0].length - 1; j++){
                copy[i][j] = graph[i][j];
            }
        }
    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        copy[y][x] = 0;
        int count = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                if(check(cur[0] + dx[i], cur[1] + dy[i])){
                    copy[cur[1] + dy[i]][cur[0] + dx[i]] = 0;
                    q.add(new int[]{cur[0] + dx[i], cur[1] + dy[i]});
                }
            }
            count++;
        }

        return count;
    }

    static boolean check(int x, int y){
        if(x < 1 || y < 1 || x >= graph[0].length - 1 || y >= graph.length - 1){
            return false;
        }
        return copy[y][x] > 0;
    }

    static boolean checkAround(int x, int y){
        if(x < 1 || y < 1 || x >= graph[0].length - 1 || y >= graph.length - 1){
            return false;
        }
        return graph[y][x] > 0 && around[y][x] < 4;
    }
}
