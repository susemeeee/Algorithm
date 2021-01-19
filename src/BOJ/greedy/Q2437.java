/*
 * Q2437.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.*;

public class Q2437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        List<Integer> weights = new ArrayList<>();

        for(int i = 0; i < n; i++){
            weights.add(Integer.parseInt(input[i]));
        }

        if(!weights.contains(1)){
            System.out.println(1);
            return;
        }
        if(n == 1){
            System.out.println(weights.get(0) + 1);
            return;
        }

        Collections.sort(weights);

        int sum = 0;
        for (Integer weight : weights) {
            if (sum + 1 < weight) {
                break;
            }
            sum += weight;
        }

        System.out.println(sum + 1);
    }
}
