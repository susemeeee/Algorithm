/*
 * Q17861.java
 * Author : 박찬형
 * Created Date : 2021-07-09
 */
package programmers.level1;

public class Q17861 {
    private char[][] map;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        map = new char[n][n];

        fillMap(arr1);
        fillMap(arr2);

        for(int i = 0; i < map.length; i++){
            answer[i] = String.valueOf(map[i]);
        }
        return answer;
    }

    private void fillMap(int[] arr){
        for(int i = 0; i < arr.length; i++){
            String binary = Integer.toBinaryString(arr[i]);
            String s = "0".repeat(arr.length - binary.length()) + binary;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    map[i][j] = '#';
                }
                else if(map[i][j] != '#'){
                    map[i][j] = ' ';
                }
            }
        }
    }
}
