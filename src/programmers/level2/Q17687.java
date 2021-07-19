/*
 * Q17687.java
 * Author : 박찬형
 * Created Date : 2021-07-19
 */
package programmers.level2;

public class Q17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        int turn = 1;
        int count = 0;
        int index = 0;
        int number = 0;
        String curNumberStr = Integer.toString(number++, n);

        while(count < t){
            if(index >= curNumberStr.length()){
                index = 0;
                curNumberStr = Integer.toString(number++, n);
            }

            if(turn == p){
                char c = curNumberStr.charAt(index);

                if(c >= 'a'){
                    c = Character.toUpperCase(c);
                }

                result.append(c);
                count++;
            }

            if(turn == m){
                turn = 1;
            }
            else{
                turn++;
            }
            index++;
        }

        return result.toString();
    }
}
