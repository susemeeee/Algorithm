/*
 * Q1238.java
 * Author : 박찬형
 * Created Date : 2021-02-10
 */
package BOJ.graph;

import java.util.*;

public class Q1238 {
    static Queue<int[]>[] roads;
    static Queue<int[]>[] returnRoads;
    static int[] costs;
    static int[] returnCosts;
    static int end = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt() - 1;
        scanner.nextLine();
        roads = new Queue[N];
        returnRoads = new Queue[N];
        costs = new int[N];
        returnCosts = new int[N];
        end = X;
        for(int i = 0; i < N; i++){
            roads[i] = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            returnRoads[i] = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            if(i != X){
                costs[i] = 1000000000;
                returnCosts[i] = 1000000000;
            }
        }
        for(int i = 0; i < M; i++){
            String[] input = scanner.nextLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            roads[to].add(new int[]{from, cost});
            returnRoads[from].add(new int[]{to, cost});
        }

        party(end);
        returnParty(end);
        int max = costs[0] + returnCosts[0];
        for(int i = 1; i < N; i++){
            if(costs[i] + returnCosts[i] > max){
                max = costs[i] + returnCosts[i];
            }
        }
        System.out.println(max);
    }

    static void party(int start){
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{start, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            while(!roads[cur[0]].isEmpty()){
                int[] next = roads[cur[0]].poll();
                if(cur[1] + next[1] < costs[next[0]]){
                    queue.add(new int[]{next[0], cur[1] + next[1]});
                    costs[next[0]] = cur[1] + next[1];
                }
            }
        }
    }

    static void returnParty(int start){
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{start, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            while(!returnRoads[cur[0]].isEmpty()){
                int[] next = returnRoads[cur[0]].poll();
                if(cur[1] + next[1] < returnCosts[next[0]]){
                    queue.add(new int[]{next[0], cur[1] + next[1]});
                    returnCosts[next[0]] = cur[1] + next[1];
                }
            }
        }
    }
}
