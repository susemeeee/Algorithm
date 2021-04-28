/*
 * Q72411.java
 * Author : 박찬형
 * Created Date : 2021-04-28
 */
package programmers.level2;

import java.util.*;

public class Q72411 {
    private Map<String, Integer> map;
    private Map<Integer, Integer> maxTable;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        maxTable = new HashMap<>();
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
            for(int j = 0; j < orders[i].length(); j++){
                makeMenu(orders[i].toCharArray(), new StringBuilder().append(orders[i].charAt(j)), j, course, 1);
            }

        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() >= 2){
                int key = entry.getKey().length();
                if(!maxTable.containsKey(key)){
                    maxTable.put(key, entry.getValue());
                }
                else if(entry.getValue() > maxTable.get(key)){
                    maxTable.replace(key, entry.getValue());
                }
            }
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int key = entry.getKey().length();
            if(maxTable.containsKey(key) && maxTable.get(key).equals(entry.getValue())){
                result.add(entry.getKey());
            }
        }

        result.sort(String::compareTo);
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public void makeMenu(char[] order, StringBuilder builder, int index, int[] course, int length){
        if(length > course[course.length - 1]){
            return;
        }
        if(existLength(course, length)){
            String s = builder.toString();
            if(!map.containsKey(s)){
                map.put(s, 1);
            }
            else{
                map.replace(s, map.get(s) + 1);
            }
        }
        for(int i = index + 1; i < order.length; i++){
            if(builder.length() > length){
                builder.delete(length, builder.length());
            }
            makeMenu(order, builder.append(order[i]), i, course, length + 1);
        }
    }

    public boolean existLength(int[] course, int length){
        for(int i : course){
            if(length == i){
                return true;
            }
        }
        return false;
    }
}
