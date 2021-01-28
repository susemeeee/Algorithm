/*
 * Q9576.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.greedy;

import java.util.*;

public class Q9576 {
    static int[][] student;
    static List<Integer> book;
    static Scanner scanner = new Scanner(System.in);
    static int count;

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < tests; i++){
            count = 0;
            test();
        }
    }

    static void test(){
        String[] input = scanner.nextLine().split(" ");
        int bookCount = Integer.parseInt(input[0]);
        int studentCount = Integer.parseInt(input[1]);
        book = new ArrayList<>();
        student = new int[studentCount][2];

        for(int i = 0; i < bookCount; i++){
            book.add(-1);
        }

        for(int i = 0; i < studentCount; i++){
            input = scanner.nextLine().split(" ");
            student[i] = new int[]{Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};
        }

        if(studentCount == 1){
            System.out.println(1);
            return;
        }

        Arrays.sort(student, Comparator.comparingInt(o -> o[1]));

        for(int i = 0; i < studentCount; i++){
            for(int j = student[i][0]; j <= student[i][1]; j++){
                if(book.get(j) == -1){
                    book.set(j, 1);
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
