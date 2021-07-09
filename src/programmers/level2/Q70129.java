/*
 * Q70129.java
 * Author : 박찬형
 * Created Date : 2021-07-09
 */
package programmers.level2;

public class Q70129 {
    public int[] solution(String s) {
        int step = 0;
        int remove = 0;
        int index = 0;
        int collect = 0;
        while(!s.equals("1")){
            if(s.charAt(index) == '0'){
                remove++;
            }
            else{
                collect++;
            }

            index++;

            if(index >= s.length()){
                s = convert(collect);
                step++;
                index = 0;
                collect = 0;
            }
        }
        return new int[]{step, remove};
    }

    private String convert(int n){
        StringBuilder builder = new StringBuilder();
        while(n > 0){
            builder.append(n % 2);
            n /= 2;
        }

        return builder.reverse().toString();
    }
}
