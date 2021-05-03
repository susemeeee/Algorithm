/*
 * Q12978.java
 * Author : 박찬형
 * Created Date : 2021-05-03
 */
package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q12978 {
    private int[][] graph;
    private int[] costs;
    private boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new int[N][N];
        costs = new int[N];
        visited = new boolean[N];

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.addAll(Arrays.asList(road));
        while(!queue.isEmpty()){
            int[] r = queue.poll();
            if(graph[r[0] - 1][r[1] - 1] == 0){
                graph[r[0] - 1][r[1] - 1] = r[2];
                graph[r[1] - 1][r[0] - 1] = r[2];
            }
        }

        for(int i = 1; i < costs.length; i++){
            costs[i] = -1;
        }

        visit();
        System.out.println(Arrays.toString(costs));
        for(int c : costs){
            if(c != -1 && c <= K){
                answer++;
            }
        }
        return answer;
    }

    private void visit(){
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{0, 0});
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < graph[cur[0]].length; i++){
                if(graph[cur[0]][i] != 0 && (costs[i] == -1 || costs[cur[0]] + graph[cur[0]][i] < costs[i])){
                    costs[i] = costs[cur[0]] + graph[cur[0]][i];
                    
                    queue.add(new int[]{i, costs[i]});
                    visited[i] = true;
                }
            }
        }
    }
}
