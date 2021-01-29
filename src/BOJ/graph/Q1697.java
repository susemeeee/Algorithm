/*
 * Q1697.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.*;

public class Q1697 {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(visit(scanner.nextInt(), scanner.nextInt()));
    }

    static int visit(int start, int end){
        if(end == start){
            return 0;
        }
        if(end < start){
            return Math.abs(end - start);
        }

        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();
        queue.add(start);
        int cur = -1;
        int count = 1;
        int curCount = 0;
        visited[start] = true;
        while(!visited[end] && !queue.isEmpty()){
            if(count == 0){
                counts.add(curCount);
                curCount = 0;
                time++;
                count = counts.poll();
            }
            cur = queue.poll();
            if(check(cur - 1)){
                visited[cur - 1] = true;
                queue.add(cur - 1);
                curCount++;
            }
            if(check(cur + 1)){
                visited[cur + 1] = true;
                queue.add(cur + 1);
                curCount++;
            }
            if(check(cur * 2)){
                visited[cur * 2] = true;
                queue.add(cur * 2);
                curCount++;
            }

            count--;
        }

        return time + 1;
    }

    static boolean check(int pos){
        if(pos < 0 || pos > 100000){
            return false;
        }
        if(visited[pos]){
            return false;
        }
        return true;
    }
}
