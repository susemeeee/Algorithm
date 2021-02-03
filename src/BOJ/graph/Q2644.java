/*
 * Q2644.java
 * Author : 박찬형
 * Created Date : 2021-02-03
 */
package BOJ.graph;

import java.util.*;

public class Q2644 {
    static List<Queue<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int edge = scanner.nextInt();
        scanner.nextLine();
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph.add(new LinkedList<>());
        }
        for(int i = 0; i < edge; i++){
            String[] input = scanner.nextLine().split(" ");
            graph.get(Integer.parseInt(input[0]) - 1).add(Integer.parseInt(input[1]) - 1);
            graph.get(Integer.parseInt(input[1]) - 1).add(Integer.parseInt(input[0]) - 1);
        }

        System.out.println(visit(start - 1, end - 1));
    }

    static int visit(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int result = 0;
        int count = 1;
        int nextCount = 0;
        while(!queue.isEmpty()){
            if(count == 0){
                count = nextCount;
                nextCount = 0;
                result++;
            }
            int cur = queue.poll();
            count--;
            if(cur == end){
                visited[end] = true;
                break;
            }
            while(!graph.get(cur).isEmpty()){
                int next = graph.get(cur).poll();
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    nextCount++;
                }
            }
        }

        if(!visited[end]){
            return -1;
        }
        return result;
    }
}
