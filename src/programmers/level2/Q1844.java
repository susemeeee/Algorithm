/*
 * Q1844.java
 * Author : 박찬형
 * Created Date : 2021-06-19
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q1844 {
    public int solution(int[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int count = 1;
        int next = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(next == 0){
                count++;
                next = queue.size() + 1;
            }
            next--;

            for(int i = 0; i < dy.length; i++){
                int[] visit = {cur[0] + dy[i], cur[1] + dx[i]};
                if(visit[0] < 0 || visit[0] >= maps.length || visit[1] < 0 || visit[1] >= maps[0].length){
                    continue;
                }
                if(maps[visit[0]][visit[1]] == 0 || visited[visit[0]][visit[1]]){
                    continue;
                }
                if(visit[0] == maps.length - 1 && visit[1] == maps[0].length - 1){
                    return count + 1;
                }
                queue.add(visit);
                visited[visit[0]][visit[1]] = true;
            }
        }
        return -1;
    }
}
