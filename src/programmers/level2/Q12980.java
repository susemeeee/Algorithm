/*
 * Q12980.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level2;

public class Q12980 {
    public int solution(int n) {
        int ans = 0;
        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}
