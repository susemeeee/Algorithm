/*
 * Week3.java
 * Author : 박찬형
 * Created Date : 2021-08-19
 */
package programmers.weekly;

import java.util.*;

public class Week3 {
    static class Block{
        private int area;
        private int[][] block;

        public Block(int[][] block, int area){
            this.block = block;
            this.area = area;
        }

        public void rotate(){
            int[][] newBlock = new int[block[0].length][block.length];

            for (int i = 0; i < block.length; i++) {
                for (int j = 0; j < block[0].length; j++) {
                    newBlock[j][newBlock[0].length - i - 1] = block[i][j];
                }
            }

            block = newBlock;
        }
    }
    private boolean[][] visitedTable;
    private boolean[][] visitedBoard;
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    private Stack<Block> holeStack;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        visitedTable = new boolean[table.length][table.length];
        visitedBoard = new boolean[game_board.length][game_board.length];
        Queue<Block> blocks = new PriorityQueue<>(Comparator.comparingInt(value -> value.area * -1));
        Queue<Block> holes = new PriorityQueue<>(Comparator.comparingInt(value -> value.area * -1));

        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table.length; j++){
                if(table[i][j] == 1 && !visitedTable[i][j]){
                    blocks.add(generateBlock(j, i, table, true));
                }
                if(game_board[i][j] == 0 && !visitedBoard[i][j]){
                    holes.add(generateBlock(j, i, game_board, false));
                }
            }
        }

        holeStack = new Stack<>();
        holeStack.addAll(holes);
        while(!blocks.isEmpty() && !holes.isEmpty()){
            answer += check(blocks.poll());
        }
        return answer;
    }

    private Block generateBlock(int x, int y, int[][] table, boolean isTable){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        if(isTable){
            visitedTable[y][x] = true;
        }
        else{
            visitedBoard[y][x] = true;
        }
        int minX = x;
        int maxX = x;
        int minY = y;
        int maxY = y;
        int area = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < dx.length; i++){
                int[] next = new int[]{cur[0] + dy[i], cur[1] + dx[i]};
                if(isWrongPos(next[0], table.length) || isWrongPos(next[1], table.length) ||
                        table[next[0]][next[1]] == (isTable ? 0 : 1)){
                    continue;
                }
                if(isTable && visitedTable[next[0]][next[1]]){
                    continue;
                }
                else if(!isTable && visitedBoard[next[0]][next[1]]){
                    continue;
                }


                if(isTable){
                    visitedTable[next[0]][next[1]] = true;
                }
                else{
                    visitedBoard[next[0]][next[1]] = true;
                }
                area++;
                queue.add(next);

                if(next[0] < minY){
                    minY = next[0];
                }
                else if(next[0] > maxY){
                    maxY = next[0];
                }
                if(next[1] < minX){
                    minX = next[1];
                }
                else if(next[1] > maxX){
                    maxX = next[1];
                }
            }
        }

        int[][] block = new int[maxY - minY + 1][maxX - minX + 1];
        for(int i = 0; i < block.length; i++){
            for(int j = 0; j < block[0].length; j++){
                block[i][j] = table[minY + i][minX + j];
            }
        }

        return new Block(block, area);
    }

    private int check(Block block){
        Stack<Block> stack = new Stack<>();
        boolean fit = false;
        while(!holeStack.isEmpty()){
            Block hole = holeStack.pop();
            if(hole.area < block.area){
                stack.push(hole);
                continue;
            }

            fit = false;
            for(int rot = 0; rot < 4; rot++){
                if(block.block.length != hole.block.length || block.block[0].length != hole.block[0].length){
                    block.rotate();
                    continue;
                }

                fit = true;
                for(int j = 0; j < block.block.length; j++){
                    for(int k = 0; k < block.block[0].length; k++){
                        if(block.block[j][k] == hole.block[j][k]){
                            fit = false;
                            break;
                        }
                    }
                }

                if(fit){
                    break;
                }
                block.rotate();
            }

            if(fit){
                break;
            }
            stack.push(hole);
        }
        holeStack.addAll(stack);

        return fit ? block.area : 0;
    }

    private boolean isWrongPos(int pos, int size){
        return pos < 0 || pos >= size;
    }
}
