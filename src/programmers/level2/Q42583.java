/*
 * Q42583.java
 * Author : 박찬형
 * Created Date : 2021-07-06
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> trucks = new LinkedList<>();
        for(int w : truck_weights){
            trucks.add(w);
        }
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }

        int bridgeWeight = 0;
        while(!trucks.isEmpty()){
            int out = bridge.poll();
            bridgeWeight -= out;
            if(bridgeWeight + trucks.peek() <= weight){
                int in = trucks.poll();
                bridge.add(in);
                bridgeWeight += in;
            }
            else{
                bridge.add(0);
            }

            time++;
        }

        int count = 0;
        while(!bridge.isEmpty()){
            count++;
            if(bridge.poll() != 0){
                time += count;
                count = 0;
            }
        }

        return time;
    }
}
