/*
 * Q72412.java
 * Author : 박찬형
 * Created Date : 2021-04-29
 */
package programmers.level2;

import java.util.*;

public class Q72412 {
    private Map<String, List<Integer>> table;

    public int[] solution(String[] info, String[] query) {
        table = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            String[] element = info[i].split(" ");
            int score = Integer.parseInt(element[4]);
            inputTable(element, 0, new StringBuilder(), 0);
        }

        for(Map.Entry<String, List<Integer>> entry : table.entrySet()){
            Collections.sort(entry.getValue());
        }

        int[] result = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String[] element = query[i].split(" ");
            String generatedQuery = generateQuery(element);
            int score = Integer.parseInt(element[7]);
            result[i] = search(generatedQuery, score);
        }
        return result;
    }

    private void inputTable(String[] element, int depth, StringBuilder builder, int prevLength){
        if(depth == 4){
            String key = builder.toString();
            if(!table.containsKey(key)){
                table.put(key, new ArrayList<>());
            }
            table.get(key).add(Integer.parseInt(element[depth]));
            return;
        }

        builder.append(element[depth]);
        inputTable(element, depth + 1, builder, builder.length());
        builder.delete(prevLength, builder.length());
        builder.append("-");
        inputTable(element, depth + 1, builder, builder.length());
    }

    private String generateQuery(String[] element){
        StringBuilder builder = new StringBuilder();
        int[] indexList = {0, 2, 4, 6};

        for(int i = 0; i < indexList.length; i++){
            builder.append(element[indexList[i]]);
        }

        return builder.toString();
    }

    private int search(String query, int score){
        if(!table.containsKey(query)){
            return 0;
        }
        List<Integer> value = table.get(query);
        if(value.size() == 0){
            return 0;
        }
        else if(value.size() == 1){
            return value.get(0) >= score ? 1 : 0;
        }

        int minIndex = 0;
        int maxIndex = value.size() - 1;
        int index = (minIndex + maxIndex) / 2;
        while(maxIndex - minIndex > 0 && index >= 0 && index < value.size()){
            if(value.get(index) < score){
                minIndex = index + 1;
            }
            else{
                maxIndex = index;
            }

            index = (minIndex + maxIndex) / 2;
        }

        if(index == value.size() - 1 && value.get(index) < score){
            return 0;
        }
        return value.size() - index;
    }
}
