/*
 * Q15904.java
 * Author : 박찬형
 * Created Date : 2021-01-27
 */
package BOJ.greedy;

import java.util.Scanner;

public class Q15904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] answer = {'U', 'C', 'P', 'C'};

        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == answer[count]){
                count++;
            }
            if(count == answer.length){
                break;
            }
        }
        if(count == answer.length){
            System.out.println("I love UCPC");
            return;
        }
        System.out.println("I hate UCPC");
    }
}
