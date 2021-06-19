/*
 * Q49189.java
 * Author : 박찬형
 * Created Date : 2021-06-19
 */
package programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q49189 {
    public int solution(int n, int[][] edge){
        Map<Integer, Queue<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
        }
        for(int i = 0; i < edge.length; i++){
            graph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            graph.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int answer = 0;
        int next = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(next == 0){
                answer = queue.size() + 1;
                next = answer;
            }
            next--;

            while(!graph.get(cur).isEmpty()){
                int visit = graph.get(cur).poll();
                if(!visited[visit]){
                    queue.add(visit);
                    visited[visit] = true;
                }
            }
        }

        return answer;
    }
}
