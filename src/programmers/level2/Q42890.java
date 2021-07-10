/*
 * Q42980.java
 * Author : 박찬형
 * Created Date : 2021-07-10
 */
package programmers.level2;

import java.util.*;

public class Q42890 {
    private List<List<Integer>> collect;

    public int solution(String[][] relation) {
        collect = new LinkedList<>();
        for(int i = 0; i < relation[0].length; i++){
            List<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            check(relation, 1, indexes);
        }

        Collections.sort(collect, Comparator.comparingInt(List::size));
        delete();

        return collect.size();
    }

    private void check(String[][] relation, int depth, List<Integer> indexes){
        if(depth > relation[0].length){
            return;
        }

        Set<String> tuples = new HashSet<>();
        for(int i = 0; i < relation.length; i++){
            StringBuilder tuple = new StringBuilder();
            for(int j = 0; j < indexes.size(); j++){
                tuple.append(relation[i][indexes.get(j)]);
            }

            if(!tuples.contains(tuple.toString())){
                tuples.add(tuple.toString());
            }
            else{
                for(int k = indexes.get(indexes.size() - 1) + 1; k < relation[0].length; k++){
                    List<Integer> newIndexes = new ArrayList<>(indexes);
                    newIndexes.add(k);
                    check(relation, depth + 1, newIndexes);
                }
                return;
            }
        }

        collect.add(indexes);
    }

    private void delete(){
        for(int i = 0; i < collect.size() - 1; i++){
            for(int j = i + 1; j < collect.size(); j++){
                if(collect.get(i).size() == collect.get(j).size()){
                    continue;
                }
                if(!compare(collect.get(i), collect.get(j))){
                    collect.remove(j);
                    j--;
                }
            }
        }
    }

    private boolean compare(List<Integer> list1, List<Integer> list2){
        int count = 0;
        for(int i = 0; i < list1.size(); i++){
            if(list2.contains(list1.get(i))){
                count++;
            }
        }

        return count < list1.size();
    }
}
