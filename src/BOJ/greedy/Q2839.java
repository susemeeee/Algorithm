/*
 * Q2839.java
 * Author : 박찬형
 * Created Date : 2021-01-13
 */
//참고
package BOJ.greedy;

import java.util.*;

public class Q2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        int[] counts = new int[5001];

        counts[1] = 999999;
        counts[2] = 999999;

        for(int i = 3; i <= weight; i++){
            counts[i] = 999999;
            counts[i] = Math.min(counts[i], counts[i - 3] + 1);
            if(i >= 5){
                counts[i] = Math.min(counts[i], counts[i - 5] + 1);
            }
        }

        if(counts[weight] == 999999){
            System.out.println(-1);
        }
        else{
            System.out.println(counts[weight]);
        }
    }
}
