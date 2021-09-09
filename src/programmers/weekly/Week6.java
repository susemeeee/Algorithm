/*
 * Week6.java
 * Author : 박찬형
 * Created Date : 2021-09-09
 */
package programmers.weekly;

import java.util.PriorityQueue;
import java.util.Queue;

public class Week6 {
    static class Boxer{
        private int number;
        private int weight;
        private int win;
        private int lose;
        private int bigBoxerWin;
        private double winRate;

        public Boxer(int number, int weight){
            this.number = number;
            this.weight = weight;
            win = 0;
            lose = 0;
            bigBoxerWin = 0;
            winRate = 0;
        }

        public int compare(Boxer other){
            if(winRate == other.winRate){
                if(bigBoxerWin == other.bigBoxerWin){
                    if(weight == other.weight){
                        return number - other.number;
                    }

                    return other.weight - weight;
                }

                return other.bigBoxerWin - bigBoxerWin;
            }

            return other.winRate - winRate > 0 ? 1 : -1;
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        Queue<Boxer> queue = new PriorityQueue<>(Boxer::compare);

        for(int i = 0; i < head2head.length; i++){
            Boxer boxer = new Boxer(i + 1, weights[i]);
            for(int j = 0; j < head2head[i].length(); j++){
                if(head2head[i].charAt(j) == 'N'){
                    continue;
                }
                if(head2head[i].charAt(j) == 'L'){
                    boxer.lose++;
                    continue;
                }
                boxer.win++;
                if(boxer.weight < weights[j]){
                    boxer.bigBoxerWin++;
                }
            }
            if(boxer.win != 0 || boxer.lose != 0){
                boxer.winRate = boxer.win / ((double)boxer.win + boxer.lose);
            }
            queue.add(boxer);
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = queue.poll().number;
        }

        return answer;
    }
}
