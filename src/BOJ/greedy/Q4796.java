/*
 * Q4796.java
 * Author : 박찬형
 * Created Date : 2021-01-19
 */
package BOJ.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer[]> tests = new ArrayList<>();

        while(true){
            String[] input = scanner.nextLine().split(" ");

            if(input[0].equals("0") && input[1].equals("0") && input[2].equals("0")){
                break;
            }

            Integer[] test = new Integer[3];
            test[0] = Integer.parseInt(input[0]);
            test[1] = Integer.parseInt(input[1]);
            test[2] = Integer.parseInt(input[2]);

            tests.add(test);
        }

        int caseNum = 1;

        for (Integer[] test : tests) {
            int V = test[2];
            int P = test[1];
            int L = test[0];
            int result = 0;

            while(V > 0){
                if(V <= L){
                    result += V;
                    V = 0;
                    continue;
                }
                result += L;
                if(V <= P){
                    V = 0;
                    continue;
                }
                V -= P;
            }

            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }
    }
}
