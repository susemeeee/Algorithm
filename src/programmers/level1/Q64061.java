/*
 * Q64061.java
 * Author : 박찬형
 * Created Date : 2021-07-07
 */
package programmers.level1;

import java.util.Stack;

public class Q64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] boardStack = new Stack[board.length];
        for(int i = 0; i < board.length; i++){
            boardStack[i] = new Stack<>();
        }
        for(int i = 0; i < board[0].length; i++){
            for(int j = board.length - 1; j >= 0; j--){
                int item = board[j][i];
                if(item == 0){
                    break;
                }
                boardStack[i].push(board[j][i]);
            }
        }

        Stack<Integer> movedStack = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int index = moves[i] - 1;
            if(boardStack[index].isEmpty()){
                continue;
            }

            int pick = boardStack[index].pop();
            if(movedStack.isEmpty() || movedStack.peek() != pick){
                movedStack.push(pick);
            }
            else {
                movedStack.pop();
                answer += 2;
            }
        }
        return answer;
    }
}
