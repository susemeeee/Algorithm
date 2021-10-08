/*
 * Week9.java
 * Author : 박찬형
 * Created Date : 2021-10-08
 */
package programmers.weekly;

import java.util.*;

public class Week9 {
    private Map<Integer, Set<Integer>> map;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new HashMap<>();
        boolean[][] cut = new boolean[n][n];
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<>());
        }
        for(int[] wire : wires){
            int from = wire[0] - 1;
            int to = wire[1] - 1;
            map.get(from).add(to);
            map.get(to).add(from);
        }

        for(int i = 0; i < n; i++){
            Set<Integer> edges = map.get(i);
            for(int edge : edges){
                if(cut[i][edge] || cut[edge][i]){
                    continue;
                }
                int check = Math.abs(n - visit(i, edge) * 2);
                if(check < answer){
                    answer = check;
                }
                cut[i][edge] = true;
                cut[edge][i] = true;
            }
        }

        return answer;
    }

    private int visit(int cur, int cutEdge){
        boolean[] visited = new boolean[map.size()];
        visited[cur] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        int count = 1;

        while(!queue.isEmpty()){
            int e = queue.poll();
            Set<Integer> connected = map.get(e);
            for(int next : connected){
                if(next == cutEdge || visited[next]){
                    continue;
                }
                count++;
                queue.add(next);
                visited[next] = true;
            }
        }

        return count;
    }
}
