/*
 * Q77885.java
 * Author : 박찬형
 * Created Date : 2021-06-30
 */
package programmers.level2;

public class Q77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                answer[i] = 1;
                continue;
            }
            answer[i] = getMin(numbers[i]);
        }

        return answer;
    }

    private long getMin(long number){
        String bit = makeBit(number);
        if(bit.charAt(bit.length() - 1) == '0'){
            return number + 1;
        }
        else{
            long count = 0;
            for(int i = bit.length() - 1; i >= 0; i--){
                if(bit.charAt(i) == '1'){
                    count++;
                }
                else{
                    break;
                }
            }

            number = number + pow(count);
            if(count != 0){
                number -= pow(count - 1);
            }
            return number;
        }
    }

    private String makeBit(long number){
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            sb.append(number % 2);
            number /= 2;
        }

        return sb.reverse().toString();
    }

    private long pow(long count){
        long result = 1;
        for(long i = 0; i < count; i++){
            result = result * 2;
        }

        return result;
    }
}
