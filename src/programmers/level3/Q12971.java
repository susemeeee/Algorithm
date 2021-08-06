/*
 * Q12971.java
 * Author : 박찬형
 * Created Date : 2021-08-04
 */
package programmers.level3;

public class Q12971 {
    public int solution(int[] sticker) {
        if(sticker.length <= 3){
            int max = sticker[0];
            for(int i = 1; i < sticker.length; i++){
                if(sticker[i] > max){
                    max = sticker[i];
                }
            }
            return max;
        }

        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i = 2; i < sticker.length - 1; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        int[] dp2 = new int[sticker.length];
        dp2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        return Math.max(dp[sticker.length - 2], dp2[sticker.length - 1]);
    }
}
