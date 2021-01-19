/*
 * Q1744.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }

        if(n == 1){
            System.out.println(numbers[0]);
            return;
        }

        Arrays.sort(numbers);

        int positive = numbers.length - 1;
        int negative = 0;
        int result = 0;

        while(true){
            if(positive != -1 && numbers[positive] <= 0){
                positive = -1;
            }
            if(negative != -1 && numbers[negative] >= 0){
                negative = -1;
            }

            if(positive > 0 && numbers[positive] > 0 && numbers[positive - 1] > 0){
                if(numbers[positive - 1] == 1){
                    result += (numbers[positive] + 1);
                }
                else{
                    result += numbers[positive] * numbers[positive - 1];
                }
                positive -= 2;
            }
            else if(positive == 0 || (positive != -1 && numbers[positive] > 0 && numbers[positive - 1] <= 0)){
                result += numbers[positive];
                positive = -1;
            }

            if(negative < numbers.length - 1 && negative != -1 && numbers[negative] < 0 && numbers[negative + 1] < 0){
                result += numbers[negative] * numbers[negative + 1];
                negative += 2;
            }
            else if(negative == numbers.length - 1 ||
                    (negative != -1 && numbers[negative] < 0 && numbers[negative + 1] >= 0)){
                if(numbers[negative + 1] != 0){
                    result += numbers[negative];
                }
                negative = -1;
            }

            if(positive == -1 && negative == -1){
                break;
            }
        }

        System.out.println(result);
    }
}
