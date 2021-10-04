/*
 * Q1758.java
 * Author : 박찬형
 * Created Date : 2021-10-04
 */
package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> line = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++){
            line.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        int rank = 1;
        while(!line.isEmpty()){
            int money = line.poll() - (rank++ - 1);
            if(money <= 0){
                break;
            }

            sum += money;
        }

        System.out.println(sum);
    }
}
