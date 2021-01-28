/*
 * Q1260.java
 * Author : 박찬형
 * Created Date : 2021-01-28
 */
package BOJ.graph;

import java.util.*;

public class Q1260 {
    static List<Boolean> visited;
    static Queue<Integer>[] graph;
    static Queue<Integer>[] graph2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();
        scanner.nextLine();

        init(n);
        for(int i = 0; i < m; i++){
            String[] input = scanner.nextLine().split(" ");
            graph[Integer.parseInt(input[0]) - 1].add(Integer.parseInt(input[1]) - 1);
            graph[Integer.parseInt(input[1]) - 1].add(Integer.parseInt(input[0]) - 1);
            graph2[Integer.parseInt(input[0]) - 1].add(Integer.parseInt(input[1]) - 1);
            graph2[Integer.parseInt(input[1]) - 1].add(Integer.parseInt(input[0]) - 1);
        }

        dfs(start - 1);
        System.out.println();
        visited = new ArrayList<>();
        for(int i = 0; i < n; i++){
            visited.add(false);
        }
        bfs(start - 1);
    }

    static void init(int n){
        visited = new ArrayList<>();
        graph = new Queue[n];
        graph2 = new Queue[n];
        for(int i = 0; i < n; i++){
            visited.add(false);
            graph[i] = new PriorityQueue<>();
            graph2[i] = new PriorityQueue<>();
        }
    }

    static void dfs(int start){
        visited.set(start, true);
        System.out.print(start + 1 + " ");
        while(!graph[start].isEmpty()){
            int cur = graph[start].poll();
            if(!visited.get(cur)){
                dfs(cur);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> visit = new LinkedList<>();
        int cur = start;
        visited.set(cur, true);
        System.out.print(cur + 1);
        visit.add(cur);
        while(visited.contains(false) && !visit.isEmpty()){
            cur = visit.poll();
            while(!graph2[cur].isEmpty()){
                int i = graph2[cur].poll();
                if(!visited.get(i)){
                    visited.set(i, true);
                    System.out.print(" " + (i + 1));
                    visit.add(i);
                }
            }
        }
        System.out.println();
    }
}
