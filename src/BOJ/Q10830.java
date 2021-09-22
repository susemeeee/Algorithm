/*
 * Q10830.java
 * Author : 박찬형
 * Created Date : 2021-09-22
 */
package BOJ;

import java.io.*;

public class Q10830 {
    private static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        long pow = Long.parseLong(input[1]);
        int[][] matrix = new int[size][size];
        for(int i = 0; i < matrix.length; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = Integer.parseInt(input[j]) % MOD;
            }
        }

        int[][] result = new int[size][size];
        for(int i = 0; i < result.length; i++){
            result[i][i] = 1;
        }
        while(pow > 0){
            if(pow % 2 == 1){
                result = mul(result, matrix);
            }
            matrix = mul(matrix, matrix);
            pow /= 2;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int[] row : result) {
            for (int j = 0; j < result.length; j++) {
                bw.write(Integer.toString(row[j]));
                if (j < result.length - 1) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.close();
    }

    static int[][] mul(int[][] base, int[][] m){
        int[][] result = new int[base.length][base.length];

        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                int sum = 0;
                for(int k = 0; k < m.length; k++){
                    sum += (base[i][k] * m[k][j]) % MOD;
                }
                result[i][j] = sum % MOD;
            }
        }

        return result;
    }
}
