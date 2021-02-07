/*
 * Q11725.java
 * Author : 박찬형
 * Created Date : 2021-02-07
 */
package BOJ.graph;

import java.util.*;

public class Q11725 {
    static List<Queue<Integer>> graph = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        parent = new int[n];
        for(int i = 0; i < n; i++){
            graph.add(new LinkedList<>());
            parent[i] = -1;
        }
        parent[0] = 0;
        for(int i = 0; i < n - 1; i++){
            String[] input = scanner.nextLine().split(" ");
            int n1 = Integer.parseInt(input[0]) - 1;
            int n2 = Integer.parseInt(input[1]) - 1;
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        dfs(0);
        for(int i = 1; i < parent.length; i++){
            System.out.println(parent[i] + 1);
        }
    }

    static void dfs(int cur){
        while(!graph.get(cur).isEmpty()){
            int next = graph.get(cur).poll();
            if(parent[next] == -1){
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}
