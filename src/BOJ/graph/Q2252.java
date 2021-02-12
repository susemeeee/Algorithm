/*
 * Q2252.java
 * Author : 박찬형
 * Created Date : 2021-02-12
 */
package BOJ.graph;

import java.util.*;

public class Q2252 {
    static Queue<Integer>[] graph;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int student = scanner.nextInt();
        int compare = scanner.nextInt();
        scanner.nextLine();
        graph = new Queue[student];
        visited = new boolean[student];
        Queue<Integer> parent = new LinkedList<>();
        boolean[] existParent = new boolean[student];
        for(int i = 0; i < student; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < compare; i++){
            String[] input = scanner.nextLine().split(" ");
            int front = Integer.parseInt(input[0]) - 1;
            int back = Integer.parseInt(input[1]) - 1;
            existParent[back] = true;
            graph[front].add(back);
        }

        for(int i = 0; i < student; i++){
            if(!existParent[i]){
                parent.add(i);
            }
        }

        while(!parent.isEmpty()){
            int cur = parent.poll();
            visited[cur] = true;
            dfs(cur);
            stack.push(cur);
        }

        while(!stack.isEmpty()){
            System.out.print((stack.pop() + 1) + " ");
        }
    }

    static void dfs(int cur){
        while(!graph[cur].isEmpty()){
            int next = graph[cur].poll();
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
                stack.push(next);
            }
        }
    }
}
