/*
 * Q3197.java
 * Author : 박찬형
 * Created Date : 2021-09-20
 */
package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q3197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        char[][] map = new char[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
        int[] start = null;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        for(int i = 0; i < map.length; i++){
            String row = br.readLine();
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'L'){
                    queue.add(new int[]{i, j});
                    if(start != null){
                        continue;
                    }
                    start = new int[]{i, j};
                }
                else if(map[i][j] == '.'){
                    queue.add(new int[]{i, j});
                }
            }
        }

        boolean connected = false;
        int day = 0;
        final int[] dy = {1, 0, 0, -1};
        final int[] dx = {0, 1, -1, 0};
        Queue<int[]> move = new LinkedList<>();
        move.add(start);
        visited[start[0]][start[1]] = true;
        while(true){
            Queue<int[]> nextPositions = new LinkedList<>();
            while(!move.isEmpty()){
                int[] cur = move.poll();

                for(int i = 0; i < dy.length; i++){
                    int[] next = {cur[0] + dy[i], cur[1] + dx[i]};

                    if(isInvalidPosition(next, map.length, map[0].length)){
                        continue;
                    }
                    if(visited[next[0]][next[1]]){
                        continue;
                    }
                    if(map[next[0]][next[1]] == 'X'){
                        visited[next[0]][next[1]] = true;
                        nextPositions.add(next);
                        continue;
                    }
                    else if(map[next[0]][next[1]] == 'L'){
                        connected = true;
                        break;
                    }
                    move.add(next);
                    visited[next[0]][next[1]] = true;
                }
            }

            if(connected){
                break;
            }

            day++;
            move = nextPositions;
            nextPositions = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int i = 0; i < dy.length; i++){
                    int[] next = {cur[0] + dy[i], cur[1] + dx[i]};

                    if(isInvalidPosition(next, map.length, map[0].length)){
                        continue;
                    }

                    if(map[next[0]][next[1]] == 'X'){
                        map[next[0]][next[1]] = '.';
                        nextPositions.add(next);
                    }
                }
            }

            queue = nextPositions;
        }

        System.out.println(day);
    }

    static boolean isInvalidPosition(int[] pos, int height, int width){
        return pos[0] < 0 || pos[0] >= height || pos[1] < 0 || pos[1] >= width;
    }
}
