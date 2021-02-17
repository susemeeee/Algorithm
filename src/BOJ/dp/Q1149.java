/*
 * Q1149.java
 * Author : 박찬형
 * Created Date : 2021-02-17
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {
    static int[][] costs;
    static int[][] results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(bf.readLine());
        costs = new int[house][3];
        results = new int[house][3];
        for(int i = 0; i < house; i++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                costs[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < 3; i++){
            results[0][i] = paint(0, i);
        }

        System.out.println(Math.min(results[0][2], Math.min(results[0][0], results[0][1])));
    }

    static int paint(int house, int color){
        if(results[house][color] != 0){
            return results[house][color];
        }
        if(house == costs.length - 1){
            results[house][color] = costs[house][color];
            return costs[house][color];
        }

        if(color == 0){
            results[house][color] = Math.min(paint(house + 1, 1), paint(house + 1, 2)) +
                    costs[house][color];
            return results[house][color];
        }
        else if(color == 1){
            results[house][color] = Math.min(paint(house + 1, 0), paint(house + 1, 2)) +
                    costs[house][color];
            return results[house][color];
        }
        else{
            results[house][color] = Math.min(paint(house + 1, 1), paint(house + 1, 0)) +
                    costs[house][color];
            return results[house][color];
        }
    }
}
