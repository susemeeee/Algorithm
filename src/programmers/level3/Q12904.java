/*
 * Q12904.java
 * Author : 박찬형
 * Created Date : 2021-07-27
 */
package programmers.level3;

public class Q12904 {
    public int solution(String s)
    {
        int start = 0;
        int end = s.length();

        while(end - start > 1){
            if(check(s, start, end)){
                return end - start;
            }

            if(end == s.length()){
                end = end - start - 1;
                start = 0;
            }
            else{
                start++;
                end++;
            }
        }

        return 1;
    }

    private boolean check(String s, int rangeStart, int rangeEnd){
        int end = rangeStart + (rangeEnd - rangeStart) / 2;
        int start = rangeStart;
        int check = rangeEnd - 1;

        while(start < end){
            if(s.charAt(start) != s.charAt(check)){
                return false;
            }

            start++;
            check--;
        }

        return true;
    }
}
