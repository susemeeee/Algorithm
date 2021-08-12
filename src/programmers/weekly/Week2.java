/*
 * Week2.java
 * Author : 박찬형
 * Created Date : 2021-08-12
 */
package programmers.weekly;

public class Week2 {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < scores.length; i++){
            int check = scores[i][i];
            boolean result = false;
            boolean isMax = true;
            boolean isMin = true;
            int sum = 0;
            for(int j = 0; j < scores.length; j++){
                sum += scores[j][i];
                if(i == j){
                    continue;
                }
                if(result || scores[j][i] == check){
                    result = true;
                    continue;
                }
                if(isMax && check < scores[j][i]){
                    isMax = false;
                }
                if(isMin && check > scores[j][i]){
                    isMin = false;
                }
            }

            if(!result && (isMax || isMin)){
                sum -= check;
                answer.append(getGrade(sum, scores.length - 1));
                continue;
            }
            answer.append(getGrade(sum, scores.length));
        }

        return answer.toString();
    }

    private char getGrade(int score, int students){
        double avg = (double) score / students;

        if(avg >= 90){
            return 'A';
        }
        if(avg >= 80){
            return 'B';
        }
        if(avg >= 70){
            return 'C';
        }
        if(avg >= 50){
            return 'D';
        }
        return 'F';
    }
}
