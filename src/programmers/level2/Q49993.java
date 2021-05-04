/*
 * Q49993.java
 * Author : 박찬형
 * Created Date : 2021-05-04
 */
package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Q49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> req = new HashMap<>();
        int level = 0;
        for(char c : skill.toCharArray()){
            req.put(c, level++);
        }
        level--;
        boolean accept = true;
        int curLevel = 0;
        for(String s : skill_trees){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(req.containsKey(c) && curLevel < req.get(c)){
                    accept = false;
                    break;
                }
                else if(req.containsKey(c) && curLevel == req.get(c)){
                    curLevel++;
                }

                if(curLevel == level){
                    break;
                }
            }

            if(accept){
                answer++;
            }
            curLevel = 0;
            accept = true;
        }
        return answer;
    }
}
