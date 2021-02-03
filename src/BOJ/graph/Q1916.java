/*
 * Q1916.java
 * Author : 박찬형
 * Created Date : 2021-02-03
 */
package BOJ.graph;

import java.util.*;

public class Q1916 {
    static final int MAX = Integer.MAX_VALUE;
    static List<Queue<int[]>> graph = new ArrayList<>();
    static int[] costs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        scanner.nextLine();
        costs = new int[vertex];
        for(int i = 0; i < vertex; i++){
            graph.add(new PriorityQueue<>(Comparator.comparingInt(o -> o[1])));
            costs[i] = MAX;
        }
        for(int i = 0; i < edge; i++){
            String[] input = scanner.nextLine().split(" ");
            graph.get(Integer.parseInt(input[0]) - 1)
                    .add(new int[]{Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2])});
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        costs[start - 1] = 0;
        bfs(start - 1);

        System.out.println(costs[end - 1]);
    }

    static void bfs(int start){
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{start, costs[start]});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            while(!graph.get(cur[0]).isEmpty()){
                int[] next = graph.get(cur[0]).poll();
                if(next[1] + cur[1] < costs[next[0]]){
                    queue.add(new int[]{next[0], next[1] + cur[1]});
                    costs[next[0]] = next[1] + cur[1];
                }
            }
        }
    }
}
