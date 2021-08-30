/*
 * Q12952.java
 * Author : 박찬형
 * Created Date : 2021-08-17
 */
package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Q12952 {
    public int solution(int n) {
        int count = 0;

        for(int i = 0; i < n; i++){
            List<Integer> visited = new ArrayList<>();
            visited.add(i);
            count += visit(visited, 1, n);
        }

        return count;
    }

    private int visit(List<Integer> visited, int depth, int n){
        if(depth == n){
            return 1;
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(check(visited, i, depth, n)){
                visited.add(i);
                count += visit(visited, depth + 1, n);
                visited.remove(visited.size() - 1);
            }
        }

        return count;
    }

    private boolean check(List<Integer> list, int pos, int depth, int n){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == pos ||
                    (list.get(i) - (depth - i) >= 0 && list.get(i) - (depth - i) == pos) ||
                    (list.get(i) + (depth - i) < n && list.get(i) + (depth - i) == pos)){
                return false;
            }
        }

        return true;
    }
}
