/*
 * Q12985.java
 * Author : 박찬형
 * Created Date : 2021-06-27
 */
package programmers.level2;

public class Q12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(n > 1){
            if(checkTeam(a, b)){
                break;
            }

            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;

            n /= 2;
            answer++;
        }

        return answer;
    }

    private boolean checkTeam(int a, int b){
        if(a > b){
            return a - b == 1 && a % 2 == 0;
        }
        return b - a == 1 && b % 2 == 0;
    }
}
