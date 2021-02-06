/*
 * Q10451.java
 * Author : 박찬형
 * Created Date : 2021-02-06
 */
package BOJ.graph;

import java.util.*;

public class Q10451 {
    static List<Queue<Integer>> graph;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        for(int i = 0; i < tests; i++){
            init();
            int count = 0;
            for(int j = 0; j < graph.size(); j++){
                if(!graph.get(j).isEmpty()){
                    dfs(j, j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static void init(){
        graph = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        for(int i = 0; i < n; i++){
            graph.add(new LinkedList<>());
            graph.get(i).add(Integer.parseInt(input[i]) - 1);
        }
    }

    static void dfs(int start, int cur){
        int next = graph.get(cur).poll();
        if(next == start){
            return;
        }
        dfs(start, next);
    }
}
