/*
 * Week4.java
 * Author : 박찬형
 * Created Date : 2021-08-30
 */
package programmers.weekly;

import java.util.HashMap;
import java.util.Map;

public class Week4 {
    public String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(String row : table){
            String[] columns = row.split(" ");
            map.put(columns[0], new HashMap<>());
            for(int j = 1; j < columns.length; j++){
                map.get(columns[0]).put(columns[j], 5 - (j - 1));
            }
        }

        int max = 0;
        String type = "";
        for(Map.Entry<String, Map<String, Integer>> entry : map.entrySet()){
            int score = 0;
            for(int i = 0; i < languages.length; i++){
                if(!entry.getValue().containsKey(languages[i])){
                    continue;
                }
                score += entry.getValue().get(languages[i]) * preference[i];
            }

            if(score > max || (score == max && type.compareTo(entry.getKey()) > 0)){
                max = score;
                type = entry.getKey();
            }
        }

        return type;
    }
}
