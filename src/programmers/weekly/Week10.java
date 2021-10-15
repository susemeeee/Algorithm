/*
 * Week10.java
 * Author : 박찬형
 * Created Date : 2021-10-15
 */
package programmers.weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Week10 {
    public String[] solution(int[][] line) {
        Map<Long, Set<Long>> points = new HashMap<>();
        long[] min = {Long.MAX_VALUE, Long.MAX_VALUE};
        long[] max = {Long.MIN_VALUE, Long.MIN_VALUE};

        for(int i = 0; i < line.length - 1; i++){
            for(int j = i + 1; j < line.length; j++){
                long[] point = getPoint(line[i], line[j]);
                if(point != null){
                    for(int k = 0; k < point.length; k++){
                        if(point[k] > max[k]){
                            max[k] = point[k];
                        }
                        if(point[k] < min[k]){
                            min[k] = point[k];
                        }
                    }

                    if(!points.containsKey(point[0])){
                        points.put(point[0], new HashSet<>());
                    }
                    points.get(point[0]).add(point[1]);
                }
            }
        }

        String[] answer = new String[(int) (max[0] - min[0]) + 1];
        int index = answer.length - 1;
        for(long i = min[0]; i <= max[0]; i++){
            StringBuilder sb = new StringBuilder();
            for(long j = min[1]; j <= max[1]; j++){
                if(points.containsKey(i) && points.get(i).contains(j)){
                    sb.append('*');
                }
                else{
                    sb.append('.');
                }
            }
            answer[index--] = sb.toString();
        }
        return answer;
    }

    public long[] getPoint(int[] arr1, int[] arr2){
        if(((long) arr1[0] * arr2[1]) - ((long) arr1[1] * arr2[0]) == 0){
            return null;
        }

        double x = ((long)arr1[1] * arr2[2] - (long)arr1[2] * arr2[1]) / (double) (((long) arr1[0] * arr2[1]) - ((long) arr1[1] * arr2[0]));
        double y = ((long) arr1[2] * arr2[0] - (long) arr1[0] * arr2[2]) / (double) (((long) arr1[0] * arr2[1]) - ((long) arr1[1] * arr2[0]));

        if(x == (long) x && y == (long) y){
            return new long[]{(long) y, (long) x};
        }
        return null;
    }
}
