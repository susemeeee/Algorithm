/*
 * Q81303.java
 * Author : 박찬형
 * Created Date : 2021-07-26
 */
package programmers.level3;

import java.util.Stack;

public class Q81303 {
    static class Cell{
        private Cell prev;
        private Cell next;
        private final int value;

        public Cell(int value){
            this.value = value;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Cell cur = new Cell(0);
        Stack<Cell> stack = new Stack<>();

        for(int i = 1; i < n; i++){
            Cell next = new Cell(i);
            cur.next = next;
            next.prev = cur;

            cur = cur.next;
        }

        while(cur.value != k){
            cur = cur.prev;
        }

        for(String c : cmd){
            char flag = c.charAt(0);

            if(flag == 'U'){
                int move = Integer.parseInt(c.substring(2));
                for(int i = 0; i < move; i++){
                    cur = cur.prev;
                }
            }
            else if(flag == 'D'){
                int move = Integer.parseInt(c.substring(2));
                for(int i = 0; i < move; i++){
                    cur = cur.next;
                }
            }
            else if(flag == 'C'){
                stack.push(cur);
                if(cur.prev != null){
                    cur.prev.next = cur.next;
                }
                if(cur.next == null){
                    cur = cur.prev;
                }
                else{
                    cur.next.prev = cur.prev;
                    cur = cur.next;
                }
            }
            else{
                Cell recovery = stack.pop();
                if(recovery.prev != null){
                    recovery.prev.next = recovery;
                }
                if(recovery.next != null){
                    recovery.next.prev = recovery;
                }
            }
        }

        char[] result = "O".repeat(n).toCharArray();
        while(!stack.isEmpty()){
            result[stack.pop().value] = 'X';
        }
        return new String(result);
    }
}
