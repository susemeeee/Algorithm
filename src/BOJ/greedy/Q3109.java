/*
 * Q3109.java
 * Author : 박찬형
 * Created Date : 2021-01-22
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q3109 {
    static boolean[][] world;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        world = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String input2 = scanner.nextLine();
            for(int j = 0; j < col; j++){
                world[i][j] = (input2.charAt(j) == '.');
            }
        }

        int count = 0;
        int curX;
        int curY;
        for(int i = 0; i < row; i++){
            curX = 0;
            curY = i;
            if(find(curX, curY)){
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean find(int x, int y){
        if(x == col - 1){
            world[y][x] = false;
            return true;
        }
        if(!world[y][x]){
            return false;
        }
        world[y][x] = false;

        if(y > 0 && find(x + 1, y - 1)){
            return true;
        }
        else if(find(x + 1, y)){
            return true;
        }
        else if(y < row - 1 && find(x + 1, y + 1)){
            return true;
        }
        else{
            return false;
        }
    }
}
