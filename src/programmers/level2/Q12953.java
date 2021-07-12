/*
 * Q12953.java
 * Author : 박찬형
 * Created Date : 2021-07-12
 */
package programmers.level2;

public class Q12953 {
    private int prime = 2;

    public int solution(int[] arr) {
        int answer = 1;
        int endCount = 0;

        while(endCount != arr.length){
            endCount = 0;

            boolean find = false;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= 1){
                    endCount++;
                    continue;
                }

                if(arr[i] % prime == 0){
                    arr[i] /= prime;
                    find = true;
                }
            }

            if(find){
                answer *= prime;
            }
            else{
                findNextPrime();
            }
        }
        return answer;
    }

    private void findNextPrime(){
        prime++;
        while(!isPrime(prime)){
            prime++;
        }
    }

    private boolean isPrime(int n){
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
