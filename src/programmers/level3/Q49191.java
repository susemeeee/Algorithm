/*
 * Q49191.java
 * Author : 박찬형
 * Created Date : 2021-07-17
 */
package programmers.level3;

public class Q49191 {
    private int[][] board;

    public int solution(int n, int[][] results) {
        int answer = 0;
        board = new int[n][n];

        for (int[] result : results) {
            int win = result[0] - 1;
            int lose = result[1] - 1;
            board[win][lose] = 1;
            board[lose][win] = -1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || board[i][j] == 0){
                    continue;
                }

                record(board[i][j] == 1, i, j);
            }
        }

        for (int[] row : board) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (row[j] != 0) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private void record(boolean win, int index, int opposite){
        for(int i = 0; i < board.length; i++){
            if(board[index][i] == (win ? -1 : 1)){
                board[i][opposite] = win ? 1 : -1;
                board[opposite][i] = win ? -1 : 1;
            }
        }
    }
}
