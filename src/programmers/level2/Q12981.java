/*
 * Q12981.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Q12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn = 1;
        int cur = 1;
        char check = 0;
        Set<String> usedWords = new HashSet<>();
        for(String s : words){
            if(!(turn == 1 && cur == 1) && (s.charAt(0) != check || usedWords.contains(s))){
                answer[0] = cur;
                answer[1] = turn;
                break;
            }
            if(cur == n){
                turn++;
                cur = 1;
            }
            else{
                cur++;
            }
            usedWords.add(s);
            check = s.charAt(s.length() - 1);
        }

        return answer;
    }
}
