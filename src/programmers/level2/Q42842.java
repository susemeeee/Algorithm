/*
 * Q42842.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level2;

public class Q42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        if(yellow == 1){
            answer[0] = 3;
            answer[1] = 3;
        }
        int max = getMaxHeight(yellow);
        for(int i = 1; i <= max; i++){
            if(yellow % i == 0 && check(yellow / i, i, brown)){
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
            }
        }
        return answer;
    }

    private int getMaxHeight(int yellow){
        int max = 0;
        for(int i = 1; i <= yellow; i++){
            if(yellow / i < i){
                break;
            }
            if(yellow % i == 0){
                max = i;
            }
        }
        return max;
    }

    private boolean check(int width, int height, int brown){
        return width * 2 + height * 2 + 4 == brown;
    }
}
