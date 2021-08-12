/*
 * Q12907.java
 * Author : 박찬형
 * Created Date : 2021-07-31
 */
package programmers.level3;

import java.util.Arrays;

public class Q12907 {
    public int solution(int n, int[] money) {
        if(n == 0){
            return 1;
        }

        int[] table2 = new int[(n + 1) * money.length];
        for(int i = 0; i < money.length; i++){
            table2[i] = 1;
        }
        Arrays.sort(money);

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < money.length; j++){
                if(j == 0){
                    table2[i * money.length + j] = i % money[j] == 0 ? 1 : 0;
                    continue;
                }
                if(money[j] > i){
                    table2[i * money.length + j] = table2[i * money.length + j - 1];
                    continue;
                }

                table2[i * money.length + j] = (table2[i * money.length + j - 1] +
                        table2[(i - money[j]) * money.length + j]) % 1000000007;
            }
        }

        return table2[table2.length - 1];
    }
}
