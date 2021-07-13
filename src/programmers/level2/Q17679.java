/*
 * Q17679.java
 * Author : 박찬형
 * Created Date : 2021-07-13
 */
package programmers.level2;

import java.util.*;

public class Q17679 {
    private List<Character>[] board;
    private int count;
    private Queue<int[]> delete;
    private boolean[][] visited;

    public int solution(int m, int n, String[] board) {
        this.board = new LinkedList[n];
        count = 0;

        for(int i = 0; i < this.board.length; i++){
            this.board[i] = new LinkedList<>();
        }

        for(int i = board.length - 1; i >= 0; i--){
            String b = board[i];
            for(int j = 0; j < b.length(); j++){
                this.board[j].add(b.charAt(j));
            }
        }

        visited = new boolean[this.board.length][m];
        boolean result = true;
        do {
            delete = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

            for(int i = 0; i < this.board.length - 1; i++){
                for(int j = this.board[i].size() - 1; j > 0; j--){
                    remove(i, j, this.board[i].get(j));
                }
            }

            count += delete.size();
            if(delete.isEmpty()){
                result = false;
            }
            else{
                visited = new boolean[this.board.length][m];
            }
            while(!delete.isEmpty()){
                int[] cur = delete.poll();

                this.board[cur[0]].remove(cur[1]);
            }
        }while(result);

        return count;
    }

    private void remove(int x, int y, char value){
        int[] dx = {1, 0, 1};
        int[] dy = {0, -1, -1};

        int[] cur = new int[]{x, y};

        List<int[]> nextList = new ArrayList<>();

        int exclude = 0;
        for(int i = 0; i < dx.length; i++){
            int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
            if(next[0] >= board.length || next[1] >= board[next[0]].size()){
                break;
            }
            if(board[next[0]].get(next[1]) != value){
                break;
            }
            if(visited[next[0]][next[1]]){
                exclude++;
                continue;
            }
            nextList.add(next);
        }

        if(nextList.size() + exclude != 3){
            return;
        }

        for (int[] next : nextList) {
            if (!visited[next[0]][next[1]]) {
                delete.add(next);
                visited[next[0]][next[1]] = true;
            }
        }

        if(!visited[cur[0]][cur[1]]){
            delete.add(new int[]{x, y});
            visited[x][y] = true;
        }
    }
}
