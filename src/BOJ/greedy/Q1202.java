/*
 * Q1202.java
 * Author : 박찬형
 * Created Date : 2021-01-20
 */
package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer[]> gems = new ArrayList<>();
        Queue<Integer> bags = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Integer[] gem = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            gems.add(gem);
        }

        for(int i = 0; i < k; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }

        gems.sort(Comparator.comparingInt(o -> o[0]));

        long cost = 0;
        Queue<Integer> costs = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int cur = 0;

        for(int i = 0; i < k; i++){
            int bag = bags.poll();

            while(cur < n && gems.get(cur)[0] <= bag){
                costs.add(gems.get(cur)[1]);
                cur++;
            }

            if(!costs.isEmpty()){
                cost += costs.poll();
            }
        }

        System.out.println(cost);
    }
}
