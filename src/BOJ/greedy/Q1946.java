/*
 * Q1946.java
 * Author : 박찬형
 * Created Date : 2021-01-15
 */
package BOJ.greedy;

import java.util.*;

public class Q1946 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < testCount; i++){
            int peopleCount = scanner.nextInt();
            scanner.nextLine();
            int[] people = new int[peopleCount];

            for(int j = 0; j < peopleCount; j++){
                String[] input = scanner.nextLine().split(" ");
                people[Integer.parseInt(input[0]) - 1] = Integer.parseInt(input[1]);
            }

            int count = 0;
            int prev = -1;

            for(int j = 0; j < peopleCount; j++){
                if(prev == -1 || people[j] < prev){
                    prev = people[j];
                    count++;
                }
            }

            results.add(count);
        }

        for(int i = 0; i < results.size(); i++){
            System.out.println(results.get(i));
        }
    }
}
