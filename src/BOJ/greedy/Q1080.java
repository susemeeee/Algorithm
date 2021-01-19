/*
 * Q1080.java
 * Author : 박찬형
 * Created Date : 2021-01-16
 */
//참고
//2차원배열 내부요소 다 비교할거면 Arrays.deepEquals() 써야됨 equals()가 아니고
package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q1080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputSize = scanner.nextLine().split(" ");
        int height = Integer.parseInt(inputSize[0]);
        int width = Integer.parseInt(inputSize[1]);
        int[][] matrixA = new int[height][width];
        int[][] matrixB = new int[height][width];

        for(int i = 0; i < height; i++){
            String line = scanner.nextLine();
            for(int j = 0; j < width; j++){
                matrixA[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < height; i++){
            String line = scanner.nextLine();
            for(int j = 0; j < width; j++){
                matrixB[i][j] = line.charAt(j) - '0';
            }
        }

        if(height < 3 || width < 3){
            if(Arrays.deepEquals(matrixA, matrixB)){
                System.out.println(0);
            }
            else{
                System.out.println(-1);
            }
            return;
        }

        int count = 0;

        for(int i = 0; i < height - 2; i++){
            for(int j = 0; j < width - 2; j++) {
                if(matrixA[i][j] != matrixB[i][j]){
                    matrixA[i][j] = change(matrixA[i][j]);
                    matrixA[i][j + 1] = change(matrixA[i][j + 1]);
                    matrixA[i][j + 2] = change(matrixA[i][j + 2]);
                    matrixA[i + 1][j] = change(matrixA[i + 1][j]);
                    matrixA[i + 1][j + 1] = change(matrixA[i + 1][j + 1]);
                    matrixA[i + 1][j + 2] = change(matrixA[i + 1][j + 2]);
                    matrixA[i + 2][j] = change(matrixA[i + 2][j]);
                    matrixA[i + 2][j + 1] = change(matrixA[i + 2][j + 1]);
                    matrixA[i + 2][j + 2] = change(matrixA[i + 2][j + 2]);
                    count++;
                }

                if(Arrays.deepEquals(matrixA, matrixB)){
                    break;
                }
            }
            if(Arrays.deepEquals(matrixA, matrixB)){
                break;
            }
        }

        if(!Arrays.deepEquals(matrixA, matrixB)){
            count = -1;
        }

        System.out.println(count);
    }

    public static int change(int i){
        return i == 1 ? 0 : 1;
    }
}
