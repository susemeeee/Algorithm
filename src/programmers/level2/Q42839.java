/*
 * Q42839.java
 * Author : 박찬형
 * Created Date : 2021-05-02
 */
package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Q42839 {
    private Set<Integer> generated;

    public int solution(String numbers) {
        generated = new HashSet<>();
        for(int i = 0; i < numbers.length(); i++){
            if (Integer.parseInt(String.valueOf(numbers.charAt(i))) != 0) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                generate(set, numbers, new StringBuilder().append(numbers.charAt(i)), 1);
            }
        }
        return generated.size();
    }

    private void generate(Set<Integer> added, String numbers, StringBuilder collect, int length){
        if(isPrime(Integer.parseInt(collect.toString()))){
            generated.add(Integer.parseInt(collect.toString()));
        }

        for(int i = 0; i < numbers.length(); i++){
            if(!added.contains(i)){
                added.add(i);
                generate(added, numbers, collect.append(numbers.charAt(i)), length + 1);
                added.remove(i);
            }
            if(collect.length() > length){
                collect.delete(length, collect.length());
            }
        }
    }

    private boolean isPrime(int value){
        if(value <= 1){
            return false;
        }
        for(int i = 2; i <= value / 2; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
}
