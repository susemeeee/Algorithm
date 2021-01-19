/*
 * Q2217.java
 * Author : 박찬형
 * Created Date : 2021-01-15
 */
//Arrays.sort(배열, Collections.reverseOrder()) : 내림차순 정렬
package BOJ.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q2217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ropeCount = scanner.nextInt();
        Integer[] ropes = new Integer[ropeCount];

        for(int i = 0; i < ropeCount; i++){
            ropes[i] = scanner.nextInt();
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int maxWeight = -1;

        for(int i = 0; i < ropeCount; i++){
            int weight = ropes[i] * (i + 1);
            if(weight > maxWeight){
                maxWeight = weight;
            }
        }

        System.out.println(maxWeight);
    }
}
