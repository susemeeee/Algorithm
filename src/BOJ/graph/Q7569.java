/*
 * Q7569.java
 * Author : 박찬형
 * Created Date : 2021-02-02
 */
package BOJ.graph;

import java.util.*;

public class Q7569 {
    static int[][][] graph;
    static List<Integer[]> startPoints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();
        scanner.nextLine();
        graph = new int[h][m][n];
        startPoints = new ArrayList<>();
        boolean completed = true;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < m; j++){
                String[] input = scanner.nextLine().split(" ");
                for(int k = 0; k < n; k++){
                    if(completed && input[k].equals("0")){
                        completed = false;
                    }
                    if(input[k].equals("1")){
                        startPoints.add(new Integer[]{k, j, i});
                    }
                    graph[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }
        if(completed){
            System.out.println(0);
            return;
        }

        int day = visit();
        if(!checkGraph()){
            System.out.println(-1);
            return;
        }
        System.out.println(day);
    }

    static boolean checkGraph(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                for(int k = 0; k < graph[0][0].length; k++){
                    if(graph[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static int visit(){
        Queue<Integer[]> queue = new LinkedList<>(startPoints);
        Queue<Integer> counts = new LinkedList<>();
        counts.add(startPoints.size());
        int day = 0;
        int count = counts.poll();
        int newCount = 0;
        while(!queue.isEmpty()){
            if(count == 0){
                counts.add(newCount);
                count = counts.poll();
                newCount = 0;
                day++;
            }
            Integer[] cur = queue.poll();
            count--;
            if(check(cur[0] - 1, cur[1], cur[2])){
                queue.add(new Integer[]{cur[0] - 1, cur[1], cur[2]});
                graph[cur[2]][cur[1]][cur[0] - 1] = 1;
                newCount++;
            }
            if(check(cur[0] + 1, cur[1], cur[2])){
                queue.add(new Integer[]{cur[0] + 1, cur[1], cur[2]});
                graph[cur[2]][cur[1]][cur[0] + 1] = 1;
                newCount++;
            }
            if(check(cur[0], cur[1] - 1, cur[2])){
                queue.add(new Integer[]{cur[0], cur[1] - 1, cur[2]});
                graph[cur[2]][cur[1] - 1][cur[0]] = 1;
                newCount++;
            }
            if(check(cur[0], cur[1] + 1, cur[2])){
                queue.add(new Integer[]{cur[0], cur[1] + 1, cur[2]});
                graph[cur[2]][cur[1] + 1][cur[0]] = 1;
                newCount++;
            }
            if(check(cur[0], cur[1], cur[2] - 1)){
                queue.add(new Integer[]{cur[0], cur[1], cur[2] - 1});
                graph[cur[2] - 1][cur[1]][cur[0]] = 1;
                newCount++;
            }
            if(check(cur[0], cur[1], cur[2] + 1)){
                queue.add(new Integer[]{cur[0], cur[1], cur[2] + 1});
                graph[cur[2] + 1][cur[1]][cur[0]] = 1;
                newCount++;
            }
        }

        return day;
    }

    static boolean check(int x, int y, int h){
        if(x < 0 || y < 0 || h < 0 || x >= graph[0][0].length || y >= graph[0].length || h >= graph.length){
            return false;
        }
        return graph[h][y][x] == 0;
    }
}
