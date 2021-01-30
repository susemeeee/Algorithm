/*
 * Q11403.java
 * Author : 박찬형
 * Created Date : 2021-01-30
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11403 {
    static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] answer = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit(i, j)){
                    answer[i][j] = 1;
                }
                else{
                    answer[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean visit(int x, int y){
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        if(x != y){
            visited[x] = true;
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == y && x != y){
                return true;
            }
            else if(x == y && cur == y && visited[y]){
                return true;
            }
            for(int i = 0; i < graph[0].length; i++){
                if(graph[cur][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
