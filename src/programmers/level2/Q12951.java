/*
 * Q12951.java
 * Author : 박찬형
 * Created Date : 2021-07-12
 */
package programmers.level2;

import java.util.Locale;

public class Q12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] split = s.split(" ");

        for(int i = 0; i < split.length; i++){
            if(split[i].length() == 0){
                if(i < split.length - 1){
                    answer.append(" ");
                }
                continue;
            }

            char c = split[i].charAt(0);
            if(isAlphabet(c)){
                if(c >= 'a' && c <= 'z'){
                    c -= ('a' - 'A');
                }

                answer.append(c).append(split[i].substring(1).toLowerCase(Locale.ROOT));
            }
            else{
                answer.append(split[i].toLowerCase(Locale.ROOT));
            }

            if(i < split.length - 1){
                answer.append(" ");
            }
        }

        if(s.charAt(s.length() - 1) == ' '){
            answer.append(" ");
        }

        return answer.toString();
    }

    private boolean isAlphabet(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
