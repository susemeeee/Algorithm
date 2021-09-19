/*
 * Q1655.java
 * Author : 박찬형
 * Created Date : 2021-09-19
 */
package BOJ;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        Queue<Integer> big = new PriorityQueue<>();
        Queue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(mid + "\n");
        for(int i = 1; i < N; i++){
            int newValue = Integer.parseInt(br.readLine());

            if(newValue > mid){
                big.add(newValue);
                if(i % 2 == 0){
                    small.add(mid);
                    mid = big.poll();
                }
            }
            else{
                small.add(newValue);
                if(i % 2 != 0){
                    big.add(mid);
                    mid = small.poll();
                }
            }

            bw.write(mid + "\n");
        }
        bw.close();
    }
}
