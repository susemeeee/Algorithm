/*
 * Q11724.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11724 {
    static Queue<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edge = scanner.nextInt();
        scanner.nextLine();
        graph = new Queue[vertex];
        visited = new boolean[vertex];
        for(int i = 0; i < vertex; i++){
            graph[i] = new LinkedList<>();
            visited[i] = false;
        }

        for(int i = 0; i < edge; i++){
            String[] input = scanner.nextLine().split(" ");
            graph[Integer.parseInt(input[0]) - 1].add(Integer.parseInt(input[1]) - 1);
            graph[Integer.parseInt(input[1]) - 1].add(Integer.parseInt(input[0]) - 1);
        }

        int count = 0;
        for(int i = 0; i < vertex; i++){
            if(!visited[i]){
                visit(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void visit(int pos){
        visited[pos] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            while(!graph[cur].isEmpty()){
                int next = graph[cur].poll();
                if(check(next)){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    static boolean check(int pos){
        return !visited[pos];
    }
}
