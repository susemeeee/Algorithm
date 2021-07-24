/*
 * Q1836.java
 * Author : 박찬형
 * Created Date : 2021-07-24
 */
package programmers.level3;

import java.util.*;

public class Q1836 {
    enum ChangeMode{
        START, X, Y
    }

    private char[][] gameBoard;
    private boolean[][] visited;
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    private boolean find;
    private Queue<int[]> collectPosition;
    private Set<Character> tileSet;
    private Set<Character> findSet;

    public String solution(int m, int n, String[] board) {
        tileSet = new HashSet<>();
        findSet = new HashSet<>();
        generateBoard(board);
        StringBuilder remove = new StringBuilder();
        boolean findAny = true;
        collectPosition = new PriorityQueue<>(Comparator.comparingInt(o -> gameBoard[o[1]][o[0]]));

        while(findAny){
            collectPosition.clear();
            findSet.clear();

            for(int i = 0; i < gameBoard.length; i++){
                for(int j = 0; j < gameBoard[i].length; j++){
                    if(gameBoard[i][j] != '*' && gameBoard[i][j] != '.' && !findSet.contains(gameBoard[i][j])){
                        find = false;
                        visited = new boolean[m][n];
                        visited[i][j] = true;
                        check(j, i, 0, gameBoard[i][j], ChangeMode.START, j, i);
                    }
                }
            }

            findAny = !collectPosition.isEmpty();
            if(findAny){
                int[] position = collectPosition.poll();
                remove.append(gameBoard[position[1]][position[0]]);
                gameBoard[position[1]][position[0]] = '.';
                gameBoard[position[3]][position[2]] = '.';
            }
        }


        if(remove.length() != tileSet.size()){
            return "IMPOSSIBLE";
        }
        return remove.toString();
    }

    private void generateBoard(String[] board){
        gameBoard = new char[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                char c = board[i].charAt(j);
                gameBoard[i][j] = c;

                if(c != '.' && c != '*'){
                    tileSet.add(c);
                }
            }
        }
    }

    private void check(int x, int y, int turn, char value, ChangeMode mode, int firstX, int firstY){
        if(turn == 2){
            return;
        }

        for(int i = 0; i < dx.length; i++){
            if(find){
                return;
            }
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(checkValidPosition(nextX, nextY)){
                boolean turned = checkTurned(i, mode);
                if(gameBoard[nextY][nextX] == value){
                    if(turned && turn == 1){
                        continue;
                    }
                    find = true;
                    collectPosition.add(new int[]{firstX, firstY, nextX, nextY});
                    findSet.add(gameBoard[nextY][nextX]);
                    return;
                }
                else if(gameBoard[nextY][nextX] == '.'){
                    ChangeMode nextMode = mode;
                    if(turned){
                        if(mode == ChangeMode.X){
                            nextMode = ChangeMode.Y;
                        }
                        else{
                            nextMode = ChangeMode.X;
                        }
                    }
                    else if(mode == ChangeMode.START){
                        if(i < 2){
                            nextMode = ChangeMode.X;
                        }
                        else{
                            nextMode = ChangeMode.Y;
                        }
                    }

                    visited[nextY][nextX] = true;
                    check(nextX, nextY, turned ? turn + 1 : turn, value, nextMode, firstX, firstY);
                    visited[nextY][nextX] = false;
                }
            }
        }
    }

    private boolean checkValidPosition(int x, int y){
        if(x < 0 || x >= gameBoard[0].length || y < 0 || y >= gameBoard.length){
            return false;
        }
        return !visited[y][x];
    }

    private boolean checkTurned(int index, ChangeMode mode){
        if(mode == ChangeMode.START){
            return false;
        }
        else if(mode == ChangeMode.X){
            return index >= 2;
        }
        else{
            return index < 2;
        }
    }
}
