/*
 * Q68645.java
 * Author : 박찬형
 * Created Date : 2021-07-07
 */
package programmers.level2;

public class Q68645 {
    public int[] solution(int n) {
        int[][] table = new int[n][n];
        int total = n * (n + 1) / 2;
        int x = 0;
        int y = 0;
        int mode = 0;
        int cur = 0;
        int max = n;
        for(int i = 0; i < total; i++){
            table[y][x] = i + 1;
            cur++;
            if(cur == max){
                mode = switchMode(mode);
                cur = 0;
                max--;
            }
            switch (mode){
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    x--;
                    break;
            }
        }

        int[] answer = new int[total];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = table[i][j];
            }
        }
        return answer;
    }

    private int switchMode(int mode){
        if(mode == 2){
            return 0;
        }
        return mode + 1;
    }
}
