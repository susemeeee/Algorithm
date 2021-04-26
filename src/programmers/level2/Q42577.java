/*
 * Q42577.java
 * Author : 박찬형
 * Created Date : 2021-04-26
 */
package programmers.level2;

import java.util.*;

public class Q42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        int minLength = phone_book[0].length();
        Map<String, Queue<String>> map = new HashMap<>();
        for(String s : phone_book){
            String key = s.substring(0, minLength);
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(s);
        }
        for(Map.Entry<String, Queue<String>> entry : map.entrySet()){
            Queue<String> queue = entry.getValue();
            while(!queue.isEmpty()){
                String s = queue.poll();
                int length = queue.size();
                while(length != 0){
                    String compare = queue.poll();
                    if(compare.substring(0, s.length()).equals(s)){
                        return false;
                    }
                    queue.add(compare);
                    length--;
                }
            }
        }
        return true;
    }
}
