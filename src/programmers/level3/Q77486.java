/*
 * Q77486.java
 * Author : 박찬형
 * Created Date : 2021-05-03
 */
package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class Q77486 {
    private Map<String, String> table;
    private Map<String, Integer> profitTable;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        table = new HashMap<>();
        profitTable = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            table.put(enroll[i], referral[i]);
            profitTable.put(enroll[i], 0);
        }
        for(int i = 0; i < seller.length; i++){
            addProfit(seller[i], amount[i] * 100);
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = profitTable.get(enroll[i]);
        }
        return answer;
    }

    private void addProfit(String name, int profit){
        if(name.equals("-")){
            return;
        }

        int nextProfit = profit / 10;
        profitTable.replace(name, profitTable.get(name) + profit - nextProfit);
        if(nextProfit == 0){
            return;
        }
        addProfit(table.get(name), nextProfit);
    }
}
