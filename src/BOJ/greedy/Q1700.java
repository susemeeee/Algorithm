/*
 * Q1700.java
 * Author : 박찬형
 * Created Date : 2021-01-20
 */
package BOJ.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        List<Integer> holes = new ArrayList<>();
        List<Integer> names = new ArrayList<>();
        input = scanner.nextLine().split(" ");

        for(int i = 0; i < k; i++){
            names.add(Integer.parseInt(input[i]));
        }

        for(int i = 0; i < n; i++){
            holes.add(-1);
        }

        int count = 0;
        while(!names.isEmpty()){
            int cur = names.remove(0);
            if(holes.contains(-1) && !holes.contains(cur)){
                holes.set(holes.indexOf(-1), cur);
            }
            else if(!holes.contains(cur)){
                int max = -1;
                int index = -1;

                for(int i = 0; i < n; i++){
                    if(!names.contains(holes.get(i))){
                        holes.set(i, cur);
                        count++;
                        index = -1;
                        break;
                    }
                    else if(names.indexOf(holes.get(i)) > max){
                        max = names.indexOf(holes.get(i));
                        index = i;
                    }
                }

                if(index != -1){
                    holes.set(index, cur);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
