/*
 * Q1455.java
 * Author : 박찬형
 * Created Date : 2021-10-04
 */
package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] coins = new int[N][M];
        for(int[] row : coins){
            String input2 = br.readLine();
            for(int j = 0; j < row.length; j++){
                row[j] = Integer.parseInt(String.valueOf(input2.charAt(j)));
            }
        }

        int count = 0;
        final int[] dy = {-1, 0};
        final int[] dx = {0, -1};
        int[] start = {N - 1, M - 1};
        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(coins[cur[0]][cur[1]] == 1){
                count++;
                reverseCoins(cur[1], cur[0], coins);
            }

            for(int i = 0; i < dy.length; i++){
                int[] next = {cur[0] + dy[i], cur[1] + dx[i]};
                if(isInvalidPos(next)){
                    continue;
                }
                if(visited[next[0]][next[1]]){
                    continue;
                }

                visited[next[0]][next[1]] = true;
                queue.add(next);
            }
        }

        System.out.println(count);
    }

    static void reverseCoins(int x, int y, int[][] coins){
        for(int i = 0; i <= y; i++){
            for(int j = 0; j <= x; j++){
                if(coins[i][j] == 0) {
                    coins[i][j] = 1;
                }
                else{
                    coins[i][j] = 0;
                }
            }
        }
    }

    static boolean isInvalidPos(int[] pos){
        return pos[0] < 0 || pos[1] < 0;
    }
}
