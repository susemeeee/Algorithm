/*
 * Q43162.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q43162 {
    private Set<Integer> visited;
    private int count;

    public int solution(int n, int[][] computers) {
        visited = new HashSet<>();
        count = 0;
        for(int i = 0; i < computers.length; i++){
            if(!visited.contains(i)){
                visit(computers, i);
            }
        }

        return count;
    }

    private void visit(int[][] computers, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited.add(index);

        while(!queue.isEmpty()){
            int i = queue.poll();

            for(int j = 0; j < computers[i].length; j++){
                if(!visited.contains(j) && computers[i][j] == 1){
                    queue.add(j);
                    visited.add(j);
                }
            }
        }

        count++;
    }
}
