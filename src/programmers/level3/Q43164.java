/*
 * Q43164.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level3;

import java.util.*;

public class Q43164 {
    private Map<String, List<String>> table;
    private Map<String, List<Boolean>> used;
    private List<String> list;
    private String[] result;

    public String[] solution(String[][] tickets) {
        table = new HashMap<>();
        list = new LinkedList<>();
        used = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
            if(!table.containsKey(tickets[i][0])){
                table.put(tickets[i][0], new ArrayList<>());
                used.put(tickets[i][0], new ArrayList<>());
            }
            table.get(tickets[i][0]).add(tickets[i][1]);
            used.get(tickets[i][0]).add(false);
        }

        for(Map.Entry<String, List<String>> entry : table.entrySet()){
            Collections.sort(entry.getValue(), String::compareTo);
        }
        visit("ICN");

        return result;
    }

    private void visit(String cur){
        if(result != null){
            return;
        }

        list.add(cur);
        if(!table.containsKey(cur) && !isAllUsed()){
            list.remove(list.size() - 1);
            return;
        }
        if(!table.containsKey(cur) || isAllUsed()){
            result = new String[list.size()];
            for(int i = 0; i < result.length; i++){
                result[i] = list.get(i);
            }
            return;
        }

        for(int i = 0; i < table.get(cur).size(); i++){
            if(!used.get(cur).get(i)){
                used.get(cur).set(i, true);
                visit(table.get(cur).get(i));
                used.get(cur).set(i, false);
            }
        }

        list.remove(list.size() - 1);
    }

    private boolean isAllUsed(){
        for(Map.Entry<String, List<Boolean>> entry : used.entrySet()){
            if(entry.getValue().contains(false)){
                return false;
            }
        }

        return true;
    }
}
