/*
 * Q1932.java
 * Author : 박찬형
 * Created Date : 2021-02-19
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1932 {
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(bf.readLine());
        int length = 1;
        triangle = new int[depth][];
        for(int i = 0; i < depth; i++){
            String[] input = bf.readLine().split(" ");
            triangle[i] = new int[length];
            for(int j = 0; j < length; j++){
                triangle[i][j] = Integer.parseInt(input[j]);
            }
            length++;
        }

        for(int i = triangle.length - 1; i > 0; i--){
            for(int j = 1; j < triangle[i].length; j++){
                triangle[i - 1][j -1] += Math.max(triangle[i][j - 1], triangle[i][j]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}
