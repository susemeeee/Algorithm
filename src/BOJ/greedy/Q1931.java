/*
 * Q1931.java
 * Author : 박찬형
 * Created Date : 2021-01-14
 */
//comparator 사용법 : 작은 걸 음수로 리턴하게 만듬(같으면 0이 되고 크면 양수 리턴됨)
package BOJ.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] times = new int[n][2];


        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            times[i][0] = Integer.parseInt(input[0]);
            times[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(times, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            else{
                return o1[1] - o2[1];
            }
        });

        int currentTime = times[0][1];
        int count = 1;

        for(int i = 1; i < times.length; i++){

            if(times[i][0] < currentTime){
                continue;
            }
            currentTime = times[i][1];
            count++;
        }

        System.out.println(count);
    }
}
