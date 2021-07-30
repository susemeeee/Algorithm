/*
 * Q42884.java
 * Author : 박찬형
 * Created Date : 2021-07-30
 */
package programmers.level3;

import java.util.*;

public class Q42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        List<Integer> cameraList = new ArrayList<>();

        for(int[] route : routes){
            if(cameraList.isEmpty()){
                cameraList.add(route[1]);
                continue;
            }

            boolean newCamera = true;
            for(int i = 0; i < cameraList.size(); i++){
                int camera = cameraList.get(i);
                if(camera >= route[0] && camera <= route[1]){
                    newCamera = false;
                    break;
                }
            }

            if(newCamera){
                cameraList.add(route[1]);
            }
        }

        return cameraList.size();
    }
}
