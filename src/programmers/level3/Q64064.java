/*
 * Q64064.java
 * Author : 박찬형
 * Created Date : 2021-07-27
 */
package programmers.level3;

import java.util.*;

public class Q64064 {
    private Map<Integer, List<String>> idTable;
    private Map<String, Set<String>> result;
    private List<Set<String>> added;

    public int solution(String[] user_id, String[] banned_id) {
        idTable = new HashMap<>();
        result = new HashMap<>();

        for(String user : user_id){
            if(!idTable.containsKey(user.length())){
                idTable.put(user.length(), new ArrayList<>());
            }

            idTable.get(user.length()).add(user);
        }

        for(String ban : banned_id){
            match(ban);
        }

        Arrays.sort(banned_id, Comparator.comparingInt(String::length));
        int start = 0;
        int end = 0;
        int answer = 1;

        while(end <= banned_id.length){
            if(end == banned_id.length || banned_id[start].length() != banned_id[end].length()){
                added = new ArrayList<>();

                getCount(start, banned_id, new HashSet<>(), end - 1);
                start = end;
                if(added.size() != 0){
                    answer *= added.size();
                }
            }

            end++;
        }

        return answer;
    }

    private void match(String ban){
        if(!idTable.containsKey(ban.length())){
            return;
        }

        List<String> row = idTable.get(ban.length());
        for(String id : row){
            boolean check = true;

            for(int i = 0; i < id.length(); i++){
                if(ban.charAt(i) == '*'){
                    continue;
                }

                if(id.charAt(i) != ban.charAt(i)){
                    check = false;
                    break;
                }
            }

            if(check){
                if(!result.containsKey(ban)){
                    result.put(ban, new HashSet<>());
                }

                result.get(ban).add(id);
            }
        }
    }

    private void getCount(int depth, String[] banned_id, Set<String> contained, int maxDepth){
        if(depth > maxDepth){
            for(Set<String> set : added){
                if(set.equals(contained)){
                    return;
                }
            }
            added.add(new HashSet<>(contained));
            return;
        }

        Set<String> resultRow = result.get(banned_id[depth]);
        for(String ban : resultRow){
            if(!contained.contains(ban)){
                contained.add(ban);
                getCount(depth + 1, banned_id, contained, maxDepth);
                contained.remove(ban);
            }
        }
    }
}
