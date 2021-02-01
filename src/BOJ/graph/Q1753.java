/*
 * Q1753.java
 * Author : 박찬형
 * Created Date : 2021-02-01
 */
package BOJ.graph;

import java.util.*;

public class Q1753 {
    static final int MAX_COST = 99999999;
    static List<Queue<Integer[]>> graph;
    static int[] costs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        int start = scanner.nextInt() - 1;
        scanner.nextLine();
        graph = new ArrayList<>();
        costs = new int[vertex];

        for(int i = 0; i < vertex; i++){
            if(i != start){
                costs[i] = MAX_COST;
            }
            graph.add(new PriorityQueue<>(Comparator.comparingInt(o -> o[1])));
        }

        for(int i = 0; i < edge; i++){
            String[] input = scanner.nextLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            graph.get(from).add(new Integer[]{to, cost});
        }

        visit(start);
        for (int cost : costs) {
            if (cost == MAX_COST) {
                System.out.println("INF");
            } else {
                System.out.println(cost);
            }
        }
    }

    static void visit(int start){
        Queue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new Integer[]{start, costs[start]});
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            while(!graph.get(cur[0]).isEmpty()){
                Integer[] next = graph.get(cur[0]).poll();
                if(check(next[0], next[1] + cur[1])){
                    queue.add(new Integer[]{next[0], next[1] + cur[1]});
                    costs[next[0]] = next[1] + cur[1];
                }
            }
        }
    }

    static boolean check(int next, int cost){
        return cost < costs[next];
    }
}
