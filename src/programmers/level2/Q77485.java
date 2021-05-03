/*
 * Q77485.java
 * Author : 박찬형
 * Created Date : 2021-05-03
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q77485 {
    private int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        init(rows, columns);
        int index = 0;
        for(int[] query : queries){
            answer[index++] = move(query);
        }
        return answer;
    }

    private void init(int row, int column){
        matrix = new int[row][column];
        int value = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matrix[i][j] = value++;
            }
        }
    }

    private int move(int[] query){
        int startY = query[0] - 1;
        int startX = query[1] - 1;
        int endY = query[2] - 1;
        int endX = query[3] - 1;
        int curX = startX;
        int curY = startY;
        Queue<Integer> queue = new LinkedList<>();

        while(curX <= endX){
            queue.add(matrix[curY][curX++]);
        }
        curX--;
        curY++;
        while(curY <= endY){
            queue.add(matrix[curY++][curX]);
        }
        curY--;
        curX--;
        while(curX >= startX){
            queue.add(matrix[curY][curX--]);
        }
        curX++;
        curY--;
        while(curY > startY){
            queue.add(matrix[curY--][curX]);
        }

        int min = queue.peek();
        curX = startX + 1;
        curY = startY;
        while(curX <= endX){
            int next = queue.poll();
            matrix[curY][curX++] = next;
            if(next < min){
                min = next;
            }
        }
        curX--;
        curY++;
        while(curY <= endY){
            int next = queue.poll();
            matrix[curY++][curX] = next;
            if(next < min){
                min = next;
            }
        }
        curY--;
        curX--;
        while(curX >= startX){
            int next = queue.poll();
            matrix[curY][curX--] = next;
            if(next < min){
                min = next;
            }
        }
        curX++;
        curY--;
        while(curY >= startY){
            int next = queue.poll();
            matrix[curY--][curX] = next;
            if(next < min){
                min = next;
            }
        }

        return min;
    }
}
