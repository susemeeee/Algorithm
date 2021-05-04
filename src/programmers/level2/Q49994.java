/*
 * Q49994.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level2;

import java.util.*;

public class Q49994 {
    Map<Character, Map<Integer, boolean[]>> usedRoads;

    public int solution(String dirs) {
        int answer = 0;
        init();
        int[] cur = new int[2];
        for(char c : dirs.toCharArray()){
            int[] next = getNext(cur, c);
            if(Arrays.equals(cur, next)){
                continue;
            }
            else if(!isUsedRoad(cur, next, c)){
                answer++;
            }

            put(cur, next, c);
            cur = next.clone();
        }
        return answer;
    }

    private void init(){
        usedRoads = new HashMap<>();
        char[] commands = {'Y', 'X'};
        for(char c : commands){
            usedRoads.put(c, new HashMap<>());
            for(int i = 0; i < 11; i++){
                usedRoads.get(c).put(i, new boolean[10]);
            }
        }

    }

    private int[] getNext(int[] cur, char command){
        int[] next = cur.clone();
        switch (command){
            case 'U':
                next[1] = cur[1] < 5 ? cur[1] + 1 : cur[1];
                break;
            case 'D':
                next[1] = cur[1] > -5 ? cur[1] - 1 : cur[1];
                break;
            case 'L':
                next[0] = cur[0] > -5 ? cur[0] - 1 : cur[0];
                break;
            case 'R':
                next[0] = cur[0] < 5 ? cur[0] + 1 : cur[0];
                break;
        }

        return next;
    }

    private boolean isUsedRoad(int[] cur, int[] next, char command){
        int index = (command == 'U' || command == 'D') ? 1 : 0;
        int key = getPointNumber(cur[index == 0 ? 1 : 0], next[index == 0 ? 1 : 0]);
        int num = getRoadNumber(cur[index], next[index]);
        boolean[] value = usedRoads.get(generateCommand(command)).get(key);
        return value[num];
    }

    private void put(int[] cur, int[] next, char command){
        int index = (command == 'U' || command == 'D') ? 1 : 0;
        int key = getPointNumber(cur[index == 0 ? 1 : 0], next[index == 0 ? 1 : 0]);
        int num = getRoadNumber(cur[index], next[index]);
        boolean[] value = usedRoads.get(generateCommand(command)).get(key);
        value[num] = true;
    }

    private int getRoadNumber(int cur, int next){
        return Math.max(cur, next) + 4;
    }

    private int getPointNumber(int cur, int next){
        return Math.max(cur, next) + 5;
    }

    private char generateCommand(char command){
        return (command == 'U' || command == 'D') ? 'Y' : 'X';
    }
}
