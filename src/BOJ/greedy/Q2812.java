/*
 * Q2812.java
 * Author : 박찬형
 * Created Date : 2021-01-22
 */
package BOJ.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2812 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String input2 = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < n; i++){
            numbers.add(input2.charAt(i) - '0');
        }

        List<Integer> newNumbers = new ArrayList<>();
        int count = 0;
        newNumbers.add(numbers.get(0));
        int index = 1;
        for(int i = 1; i < numbers.size(); i++){
            int num = numbers.get(i);
            while(!newNumbers.isEmpty() && newNumbers.get(newNumbers.size() - 1) < num && count < k){
                newNumbers.remove(newNumbers.size() - 1);
                count++;
            }
            newNumbers.add(num);
            if(count == k){
                index = i;
                break;
            }
        }

        for(int i = index + 1; i < numbers.size(); i++){
            newNumbers.add(numbers.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - k; i++){
            sb.append(newNumbers.get(i));
        }

        System.out.println(sb.toString());
    }
}
