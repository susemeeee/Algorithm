/*
 * Q1829.java
 * Author : 박찬형
 * Created Date : 2021-06-24
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q1829 {
    public int[] solution(int m, int n, int[][] picture){
        int[][] clone = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                clone[i][j] = picture[i][j];
            }
        }

        int areaCount = 0;
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int color = clone[i][j];

                if(color != 0){
                    areaCount++;
                    int area = visit(clone, j, i, color);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }

        return new int[]{areaCount, maxArea};
    }

    private int visit(int[][] picture, int x, int y, int color){
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        picture[y][x] = 0;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < dy.length; i++){
                int[] next = new int[]{cur[0] + dy[i], cur[1] + dx[i]};
                if(next[0] < 0 || next[0] >= picture.length || next[1] < 0 || next[1] >= picture[0].length){
                    continue;
                }
                if(picture[next[0]][next[1]] == color){
                    queue.add(next);
                    picture[next[0]][next[1]] = 0;
                    area++;
                }
            }
        }

        return area;
    }
}
