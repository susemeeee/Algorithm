/*
 * Q12865.java
 * Author : 박찬형
 * Created Date : 2021-09-13
 */
package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int maxWeight = Integer.parseInt(input[1]);
        int[][] items = new int[count][2];
        for(int i = 0; i < count; i++){
            input = br.readLine().split(" ");
            items[i] = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }

        int[][] table = new int[count + 1][100001];
        for(int i = 1; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++){
                if(j - items[i - 1][0] < 0){
                    table[i][j] = table[i - 1][j];
                    continue;
                }
                table[i][j] = Math.max(table[i - 1][j], items[i - 1][1] + table[i - 1][Math.max(0, j - items[i - 1][0])]);
            }
        }

        System.out.println(table[table.length - 1][maxWeight]);
    }
}
