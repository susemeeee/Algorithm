/*
 * Q17682.java
 * Author : 박찬형
 * Created Date : 2021-07-09
 */
package programmers.level1;

public class Q17682 {
    public int solution(String dartResult) {
        int answer = 0;

        int[] result = new int[3];
        int index = -1;

        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);

            if(isNum(c)){
                index++;
                int score;
                if(c == '1' && i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0'){
                    i++;
                    score = 10;
                }
                else{
                    score = Integer.parseInt(String.valueOf(c));
                }

                result[index] = score;
            }
            else{
                switch (c){
                    case 'S':
                        break;
                    case 'D':
                        result[index] = (int) Math.pow(result[index], 2);
                        break;
                    case 'T':
                        result[index] = (int) Math.pow(result[index], 3);
                        break;
                    case '*':
                        if(index != 0){
                            result[index - 1] *= 2;
                        }
                        result[index] *= 2;
                        break;
                    case '#':
                        result[index] *= -1;
                        break;
                }
            }
        }

        for (int score : result) {
            answer += score;
        }
        return answer;
    }

    private boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
}
