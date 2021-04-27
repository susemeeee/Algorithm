/*
 * Q72410.java
 * Author : 박찬형
 * Created Date : 2021-04-27
 */
package programmers.level1;

public class Q72410 {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        new_id = new_id.toLowerCase();

        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if(isCorrect(c)){
                answer.append(c);
            }
        }

        boolean isDot = false;
        for(int i = 0; i < answer.length();){
            char c = answer.charAt(i);
            if(c == '.' && !isDot){
                isDot = true;
                i++;
                continue;
            }
            else if(c == '.'){
                answer.deleteCharAt(i);
            }
            else{
                i++;
                isDot = false;
            }

        }

        isDotEdge(answer);

        if(answer.length() == 0){
            answer.append('a');
        }

        if(answer.length() >= 16){
            answer.delete(15, answer.length());
            isDotEdge(answer);
        }

        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer.append(answer.charAt(answer.length() - 1));
            }
        }

        return answer.toString();
    }

    public boolean isCorrect(char c){
        if(c >= 'a' && c <= 'z'){
            return true;
        }
        if(c >= '0' && c <= '9'){
            return true;
        }
        return c == '.' || c == '-' || c == '_';
    }

    public void isDotEdge(StringBuilder stringBuilder){
        if(stringBuilder.charAt(0) == '.'){
            stringBuilder.deleteCharAt(0);
        }
        if(stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '.'){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
