/*
 * Q67256.java
 * Author : 박찬형
 * Created Date : 2021-07-08
 */
package programmers.level1;

public class Q67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int[] left = {3, 0};
        int[] right = {3, 2};
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                left[0] = n / 3;
                left[1] = 0;
                result.append('L');
            }
            else if(n == 3 || n == 6 || n == 9){
                right[0] = n / 3 - 1;
                right[1] = 2;
                result.append('R');
            }
            else{
                int[] dest = getPos(n);
                int leftDist = getDistance(left, dest);
                int rightDist = getDistance(right, dest);

                if(leftDist > rightDist){
                    result.append('R');
                    right = dest;
                }
                else if (leftDist == rightDist){
                    if(hand.equals("left")){
                        result.append('L');
                        left = dest;
                    }
                    else{
                        result.append('R');
                        right = dest;
                    }
                }
                else{
                    result.append('L');
                    left = dest;
                }
            }
        }
        return result.toString();
    }

    private int getDistance(int[] src, int[] dest){
        return Math.abs(dest[0] - src[0]) + Math.abs(dest[1] - src[1]);
    }

    private int[] getPos(int n){
        int[] pos = new int[2];
        if(n == 0){
            pos[0] = 3;
            pos[1] = 1;
        }
        else{
            boolean check = n % 3 == 0;
            pos[0] = check ? n / 3 - 1 : n / 3;
            pos[1] = check ? 2 : n % 3 - 1;
        }

        return pos;
    }
}
