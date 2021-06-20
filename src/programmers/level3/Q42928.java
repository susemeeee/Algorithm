/*
 * Q42928.java
 * Author : 박찬형
 * Created Date : 2021-06-20
 */
package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Q42928 {
    public int solution(int m, int n, int[][] puddles){
        int[][] map = new int[n][m];
        for(int[] puddle : puddles){
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        map[n - 1][m - 1] = 1;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n - 1, m - 1});
        visited[n - 1][m - 1] = true;
        int[] dx = {0, -1};
        int[] dy = {-1, 0};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < dy.length; i++){
                int[] next = {cur[0] + dy[i], cur[1] + dx[i]};
                if(next[0] < 0 || next[1] < 0){
                    continue;
                }
                if(map[next[0]][next[1]] != -1){
                    if(!visited[next[0]][next[1]]){
                        visited[next[0]][next[1]] = true;
                        queue.add(next);
                    }
                    map[next[0]][next[1]] += map[cur[0]][cur[1]];
                    map[next[0]][next[1]] %= 1000000007;
                }
            }
        }

        return map[0][0];
    }
}
