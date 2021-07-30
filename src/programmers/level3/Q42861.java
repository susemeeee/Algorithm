/*
 * Q42861.java
 * Author : 박찬형
 * Created Date : 2021-07-30
 */
package programmers.level3;

import java.util.*;

public class Q42861 {
    private Map<Integer, List<Integer>> graph;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.addAll(Arrays.asList(costs));

        while(!queue.isEmpty()){
            int[] bridge = queue.poll();
            boolean[] check = new boolean[n];
            check[bridge[0]] = true;
            if(find(check, bridge[0], bridge[1])){
                continue;
            }
            answer += bridge[2];
            graph.get(bridge[0]).add(bridge[1]);
            graph.get(bridge[1]).add(bridge[0]);

            boolean[] visited = new boolean[n];
            checkConnected(visited, 0, 0);
            boolean result = true;
            for (boolean b : visited) {
                if (!b) {
                    result = false;
                    break;
                }
            }

            if(result){
                break;
            }
        }

        return answer;
    }

    private void checkConnected(boolean[] visited, int depth, int pos){
        if(depth == visited.length){
            return;
        }

        List<Integer> edges = graph.get(pos);
        for(int next : edges){
            if(visited[next]){
                continue;
            }
            visited[next] = true;
            checkConnected(visited, depth + 1, next);
        }
    }

    private boolean find(boolean[] visited, int pos, int target){
        boolean result = false;
        List<Integer> edges = graph.get(pos);
        for(int e : edges){
            if(e == target){
                result = true;
                break;
            }
            if(visited[e]){
                continue;
            }

            visited[e] = true;
            if(find(visited, e, target)){
                result = true;
                break;
            }
        }

        return result;
    }
}
