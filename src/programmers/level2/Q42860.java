/*
 * Q42860.java
 * Author : 박찬형
 * Created Date : 2021-06-28
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q42860 {
    public int solution(String name) {
        boolean[] visited = new boolean[name.length()];
        Queue<Integer> queue = new LinkedList<>();
        char[] nameArray = name.toCharArray();
        int changeCount = 0;
        int curChange = 0;
        int cursorMove = 0;

        for(int i = 0; i < nameArray.length; i++){
            if(nameArray[i] != 'A'){
                changeCount++;
            }
            else{
                visited[i] = true;
            }
        }

        queue.add(0);
        visited[0] = true;
        if(nameArray[0] != 'A'){
            curChange++;
            cursorMove = getMinCount(name, 0);
            nameArray[0] = 'A';
        }
        while(curChange < changeCount){
            int curIndex = queue.poll();

            int[] front = getFront(nameArray, curIndex);
            int[] back = getBack(nameArray, curIndex);

            boolean isFront = front[1] <= back[1];
            queue.add(isFront ? front[0] : back[0]);
            cursorMove += getMinCount(name, queue.peek()) + (isFront ? front[1] : back[1]);
            nameArray[queue.peek()] = 'A';

            curChange++;
        }

        return cursorMove;
    }

    private int[] getFront(char[] name, int index){
        int distance = 0;
        while(name[index] == 'A'){
            if(index == name.length - 1){
                index = 0;
            }
            else{
                index++;
            }
            distance++;
        }

        return new int[]{index, distance};
    }

    private int[] getBack(char[] name, int index){
        int distance = 0;
        while(name[index] == 'A'){
            if(index == 0){
                index = name.length - 1;
            }
            else{
                index--;
            }
            distance++;
        }

        return new int[]{index, distance};
    }

    private int getMinCount(String name, int index){
        return Math.min('Z' - name.charAt(index) + 1, name.charAt(index) - 'A');
    }
}
