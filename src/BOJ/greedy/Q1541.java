/*
 * Q1541.java
 * Author : 박찬형
 * Created Date : 2021-01-15
 */
package BOJ.greedy;

import java.util.*;

public class Q1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        String[] inputNumbers = String.valueOf(input).split("-");
        int result = 0;

        for(int i = 0; i < inputNumbers.length; i++){
            int[] subInput = Arrays.asList(inputNumbers[i].split("\\+"))
                    .stream().mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for(int j = 0; j < subInput.length; j++){
                sum += subInput[j];
            }

            if(i == 0){
                result = sum;
            }
            else{
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
