/*
 * Q67259.java
 * Author : 박찬형
 * Created Date : 2021-07-28
 */
package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Q67259 {
    enum Mode{
        START, X, Y
    }

    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    private int[][][] cost;

    public int solution(int[][] board) {
        cost = new int[board.length][board.length][2];
        build(board);

        if(cost[cost.length - 1][cost.length - 1][0] == 0){
            return cost[cost.length - 1][cost.length - 1][1];
        }
        else if(cost[cost.length - 1][cost.length - 1][1] == 0){
            return cost[cost.length - 1][cost.length - 1][0];
        }
        return Math.min(cost[cost.length - 1][cost.length - 1][0], cost[cost.length - 1][cost.length - 1][1]);
    }

    private void build(int[][] board){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        cost[0][0] = new int[]{1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == board.length - 1 && cur[1] == board.length - 1){
                continue;
            }
            Mode curMode = Mode.values()[cur[2]];

            for(int i = 0; i < dx.length; i++){
                int[] next = new int[]{cur[0] + dy[i], cur[1] + dx[i], -1};

                if(next[0] < 0 || next[0] >= board.length || next[1] < 0 || next[1] >= board.length){
                    continue;
                }
                if(board[next[0]][next[1]] == 1){
                    continue;
                }

                boolean changeMode = false;
                Mode nextMode = curMode;
                if(curMode == Mode.START){
                    nextMode = i < 2 ? Mode.X : Mode.Y;
                }
                else if((curMode == Mode.X && i >= 2) || (curMode == Mode.Y && i < 2)){
                    changeMode = true;
                    nextMode = curMode == Mode.X ? Mode.Y : Mode.X;
                }

                int nextCost = changeMode ? 600 : 100;
                next[2] = nextMode.ordinal();

                if(curMode == Mode.START){
                    cost[next[0]][next[1]][next[2] - 1] = nextCost;
                    queue.add(next);
                }
                else if(cost[next[0]][next[1]][next[2] - 1] == 0 ||
                        cost[cur[0]][cur[1]][cur[2] - 1] + nextCost <= cost[next[0]][next[1]][next[2] - 1]){
                    cost[next[0]][next[1]][next[2] - 1] = cost[cur[0]][cur[1]][cur[2] - 1] + nextCost;
                    queue.add(next);
                }
            }
        }
    }
}
