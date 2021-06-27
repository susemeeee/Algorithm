/*
 * Q1835.java
 * Author : 박찬형
 * Created Date : 2021-06-26
 */
package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1835 {
    class Condition{
        private String from;
        private String to;
        private int distance;
        private char operator;

        public Condition(String from, String to, int distance, char operator){
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.operator = operator;
        }
    }

    private String[] friends;
    private List<Condition> conditions;
    private boolean[] used;
    private int count;

    public int solution(int n, String[] data) {
        friends = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};

        conditions = new ArrayList<>();
        for(String d : data){
            char[] split = d.toCharArray();
            conditions.add(new Condition(Character.toString(split[0]), Character.toString(split[2]),
                    Integer.parseInt(String.valueOf(split[4])), split[3]));
        }

        count = 0;
        used = new boolean[8];
        visit(0, new HashMap<>());

        return count;
    }

    private void visit(int depth, Map<String, Integer> position){
        if(depth > 7){
            if(checkCondition(position)){
                count++;
            }
            return;
        }

        for(int i = 0; i < friends.length; i++){
            if(!used[i]){
                used[i] = true;
                position.put(friends[i], depth);
                visit(depth + 1, position);
                position.remove(friends[i]);
                used[i] = false;
            }
        }
    }

    private boolean checkCondition(Map<String, Integer> position){
        for(Condition condition : conditions){
            int fromIndex = position.get(condition.from);
            int toIndex = position.get(condition.to);
            int distance = fromIndex > toIndex ? fromIndex - toIndex : toIndex - fromIndex;
            distance--;

            switch (condition.operator){
                case '=':
                    if(distance != condition.distance){
                        return false;
                    }
                    break;
                case '>':
                    if(distance <= condition.distance){
                        return false;
                    }
                    break;
                case  '<':
                    if(distance >= condition.distance){
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
