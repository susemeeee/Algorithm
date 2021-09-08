/*
 * Q1832.java
 * Author : 박찬형
 * Created Date : 2021-08-06
 */
package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Q1832 {
    public int solution(int m, int n, int[][] cityMap) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] result = new int[m][n][2];
        result[0][0] = new int[]{0, 1};
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        final int[] dx = {1, 0};
        final int[] dy = {0, 1};
        queue.add(new int[]{0, 0});

        final int MOD = 20170805;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < dx.length; i++){
                int nextX = cur[1] + dx[i];
                int nextY = cur[0] + dy[i];

                if(nextX >= n || nextY >= m){
                    continue;
                }
                if(cityMap[nextY][nextX] == 1){
                    continue;
                }

                if(cityMap[cur[0]][cur[1]] == 2){
                    result[nextY][nextX][i] = result[cur[0]][cur[1]][i] % MOD;
                }
                else{
                    result[nextY][nextX][i] = (result[cur[0]][cur[1]][0] + result[cur[0]][cur[1]][1]) % MOD;
                }

                if(!visited[nextY][nextX]){
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return (result[m - 1][n - 1][0] + result[m - 1][n - 1][1]) % MOD;
    }
}
