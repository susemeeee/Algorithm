/*
 * Q11399.java
 * Author : 박찬형
 * Created Date : 2021-01-14
 */
package BOJ.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Q11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        int[] times = new int[people];

        for(int i = 0; i < people; i++){
            times[i] = Integer.parseInt(input[i]);
        }

        List<Integer> sorted = Arrays.stream(times).boxed().collect(Collectors.toList());
        Collections.sort(sorted);
        int sum = 0;

        for(int i = 0; i < sorted.size(); i++){
            for(int j = 0; j <= i; j++){
                sum += sorted.get(j);
            }
        }

        System.out.println(sum);
    }
}
