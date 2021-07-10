/*
 * Q12909.java
 * Author : 박찬형
 * Created Date : 2021-07-10
 */
package programmers.level2;

public class Q12909 {
    boolean solution(String s) {
        int check = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                check++;
            }
            else{
                if(check == 0){
                    return false;
                }
                check--;
            }
        }

        return check == 0;
    }
}
