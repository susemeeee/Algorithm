/*
 * Q14503.java
 * Author : 박찬형
 * Created Date : 2021-09-18
 */
package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q14503 {
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] d = br.readLine().split(" ");
        int[][] floor = new int[Integer.parseInt(d[0])][Integer.parseInt(d[1])];
        d = br.readLine().split(" ");
        int[] start = new int[]{Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])};
        int count = 0;
        for(int i = 0; i < floor.length; i++){
            d = br.readLine().split(" ");
            for(int j = 0; j < floor[0].length; j++){
                floor[i][j] = Integer.parseInt(d[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(floor[cur[0]][cur[1]] == 0){
                floor[cur[0]][cur[1]] = 2;
                count++;
            }

            int nextDir = cur[2];
            int nextY;
            int nextX;
            boolean find = false;

            for(int i = 0; i < dy.length; i++){
                nextDir = rotate(nextDir);
                nextY = cur[0] + dy[nextDir];
                nextX = cur[1] + dx[nextDir];

                if(!checkPos(nextX, nextY, floor[0].length, floor.length)){
                    continue;
                }
                if(floor[nextY][nextX] >= 1){
                    continue;
                }
                queue.add(new int[]{nextY, nextX, nextDir});
                find = true;
                break;
            }
            if(!find){
                nextY = cur[0] - dy[cur[2]];
                nextX = cur[1] - dx[cur[2]];
                if(!checkPos(nextX, nextY, floor[0].length, floor.length)){
                    break;
                }
                if(floor[nextY][nextX] == 1){
                    break;
                }
                queue.add(new int[]{nextY, nextX, cur[2]});
            }
        }

        System.out.println(count);
    }

    static int rotate(int dir){
        return dir == 0 ? 3 : dir - 1;
    }

    static boolean checkPos(int x, int y, int width, int height){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
