/*
 * Q17677.java
 * Author : 박찬형
 * Created Date : 2021-06-23
 */
package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q17677 {
    public int solution(String str1, String str2){
        Queue<String> set1 = new PriorityQueue<>(String::compareTo);
        Queue<String> set2 = new PriorityQueue<>(String::compareTo);
        extractSet(str1, set1);
        extractSet(str2, set2);

        int intersectionSize = 0;
        int unionSize = 0;
        while(!set1.isEmpty() && !set2.isEmpty()){
            String substr1 = set1.peek();
            String substr2 = set2.peek();
            int compare = substr1.compareTo(substr2);
            if(compare > 0){
                set2.poll();
            }
            else if(compare < 0){
                set1.poll();
            }
            else{
                intersectionSize++;
                set1.poll();
                set2.poll();
            }
            unionSize++;
        }

        while(!set1.isEmpty()){
            set1.poll();
            unionSize++;
        }
        while(!set2.isEmpty()){
            set2.poll();
            unionSize++;
        }

        if(intersectionSize == 0 && unionSize == 0){
            return 65536;
        }
        return (int)(((float)intersectionSize / unionSize) * 65536);
    }

    private void extractSet(String str, Queue<String> set) {
        int subCount = 0;
        char[] sub = new char[2];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(checkSub(c)){
                if(c >= 'a'){
                    c -= ('a' - 'A');
                }
                sub[subCount++] = c;
                if(subCount == 2){
                    subCount = 0;
                    set.add(new String(sub));
                    sub = new char[2];
                    i--;
                }
            }
            else{
                subCount = 0;
                sub = new char[2];
            }
        }
    }

    private boolean checkSub(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}
