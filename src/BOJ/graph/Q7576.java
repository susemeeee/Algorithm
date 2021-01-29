/*
 * Q7576.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    static int[][] graph;
    static int day = 0;
    static Queue<Integer> counts = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];
        for(int i = 0; i < height; i++){
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < width; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        visit();
        if(!checkGraph()){
            day = -1;
        }
        System.out.println(day);
    }

    static void visit(){
        Queue<Integer[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 1){
                    queue.add(new Integer[]{j, i});
                    count++;
                }
            }
        }

        if(count == 0){
            day = -1;
            return;
        }

        counts.add(count);
        count = counts.poll();
        int curCount = 0;
        while(!queue.isEmpty()){
            if(count == 0){
                counts.add(curCount);
                curCount = 0;
                count = counts.poll();
                day++;
            }
            Integer[] cur = queue.poll();
            if(graph[cur[1]][cur[0]] == 1){
                if(checkPoint(cur[0] + 1, cur[1])){
                    queue.add(new Integer[]{cur[0] + 1, cur[1]});
                    graph[cur[1]][cur[0] + 1] = 1;
                    curCount++;
                }
                if(checkPoint(cur[0] - 1, cur[1])){
                    queue.add(new Integer[]{cur[0] - 1, cur[1]});
                    graph[cur[1]][cur[0] - 1] = 1;
                    curCount++;
                }
                if(checkPoint(cur[0], cur[1] + 1)){
                    queue.add(new Integer[]{cur[0], cur[1] + 1});
                    graph[cur[1] + 1][cur[0]] = 1;
                    curCount++;
                }
                if(checkPoint(cur[0], cur[1] - 1)){
                    queue.add(new Integer[]{cur[0], cur[1] - 1});
                    graph[cur[1] - 1][cur[0]] = 1;
                    curCount++;
                }

                count--;
            }

            System.out.println(count);
            System.out.println(day);
            print();

        }
    }

    static void print(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean checkPoint(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        return graph[y][x] != -1 && graph[y][x] != 1;
    }

    static boolean checkGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
