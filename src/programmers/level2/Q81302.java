/*
 * Q81302.java
 * Author : 박찬형
 * Created Date : 2021-07-10
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q81302 {
    private char[][] room;
    private int[] dx;
    private int[] dy;
    private boolean[][] visited;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0 ,0, 1, -1};

        for(int i = 0; i < places.length; i++){
            makeRoom(places[i]);
            visited = new boolean[places.length][places.length];
            answer[i] = checkDistance();
        }

        return answer;
    }

    private void makeRoom(String[] place){
        room = new char[5][5];

        for(int i = 0; i < place.length; i++){
            String row = place[i];
            for(int j = 0; j < row.length(); j++){
                room[i][j] = row.charAt(j);
            }
        }
    }

    private int checkDistance(){
        for(int i = 0; i < room.length; i++){
            for(int j = 0; j < room.length; j++){
                if(room[i][j] == 'P' && !visit(j, i)){
                    return 0;
                }
            }
        }

        return 1;
    }

    private boolean visit(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        int distance  = 0;
        int count = queue.size();
        while(!queue.isEmpty()){
            if(count == 0){
                distance++;
                count = queue.size();
            }
            if(distance == 2){
                break;
            }
            int[] cur = queue.poll();

            for(int i = 0; i < dx.length; i++){
                int[] next = {cur[0] + dy[i], cur[1] + dx[i]};
                if(next[0] >= 0 && next[0] < room.length && next[1] >= 0 && next[1] < room.length &&
                        !visited[next[0]][next[1]]){
                    if(room[next[0]][next[1]] == 'P'){
                        return false;
                    }
                    if(room[next[0]][next[1]] == 'O'){
                        queue.add(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }

            count--;
        }

        return true;
    }
}
