/*
 * Q2606.java
 * Author : 박찬형
 * Created Date : 2021-01-29
 */
package BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2606 {
    static Queue<Integer>[] graph;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computers = scanner.nextInt();
        int edges = scanner.nextInt();
        scanner.nextLine();
        graph = new Queue[computers];
        visited = new boolean[computers];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new LinkedList<>();
            visited[i] = false;
        }

        for(int i = 0; i < edges; i++){
            String[] input = scanner.nextLine().split(" ");
            graph[Integer.parseInt(input[0]) - 1].add(Integer.parseInt(input[1]) - 1);
            graph[Integer.parseInt(input[1]) - 1].add(Integer.parseInt(input[0]) - 1);
        }

        bfs();
        for(int i = 1; i < visited.length; i++){
            if(visited[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!visited[cur]){
                visited[cur] = true;
                while(!graph[cur].isEmpty()){
                    int next = graph[cur].poll();
                    if(!visited[next]){
                        queue.add(next);
                    }
                }
            }
        }
    }
}
