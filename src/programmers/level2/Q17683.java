/*
 * Q17683.java
 * Author : 박찬형
 * Created Date : 2021-07-19
 */
package programmers.level2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Q17683 {
    static class MusicInfo{
        private final String name;
        private final int time;
        private final List<String> melody;
        private final int index;

        public MusicInfo(String music, int i){
            this.index = i;
            String[] info = music.split(",");
            name = info[2];

            String[] timeInfo = info[0].split(":");
            LocalTime startTime = LocalTime.of(Integer.parseInt(timeInfo[0]), Integer.parseInt(timeInfo[1]));
            timeInfo = info[1].split(":");
            LocalTime endTime = LocalTime.of(Integer.parseInt(timeInfo[0]), Integer.parseInt(timeInfo[1]));
            time = (int) ChronoUnit.MINUTES.between(startTime, endTime);

            int index = 0;
            int count = 0;
            melody = new LinkedList<>();
            while(count < time) {
                if (index + 1 < info[3].length() && info[3].charAt(index + 1) == '#') {
                    melody.add(info[3].substring(index, index + 2));
                    index++;
                }
                else {
                    melody.add(String.valueOf(info[3].charAt(index)));
                }

                index++;
                count++;

                if (index >= info[3].length()) {
                    index = 0;
                }
            }
        }

        public int compare(MusicInfo other) {
            if(time == other.time){
                return index - other.index;
            }

            return other.time - time;
        }
    }

    private Queue<MusicInfo> result;
    private List<MusicInfo> musicList;

    public String solution(String m, String[] musicinfos) {
        init(musicinfos);
        search(m);

        if(result.isEmpty()){
            return "(None)";
        }
        return result.poll().name;
    }

    private void init(String[] musicInfos){
        result = new PriorityQueue<>(MusicInfo::compare);
        musicList = new ArrayList<>();

        for(int i = 0; i < musicInfos.length; i++){
            musicList.add(new MusicInfo(musicInfos[i], i));
        }
    }

    private void search(String m){
        for(MusicInfo info : musicList){
            int index = 0;
            int compare = 0;
            int nextCompare = 0;
            int count = 0;
            boolean check = false;

            List<String> compareMelody = new LinkedList<>();
            while(index < m.length()) {
                if (index + 1 < m.length() && m.charAt(index + 1) == '#') {
                    compareMelody.add(m.substring(index, index + 2));
                    index++;
                }
                else {
                    compareMelody.add(String.valueOf(m.charAt(index)));
                }

                index++;
                count++;
            }

            index = 0;
            count = 0;
            while(index < compareMelody.size() && compare < info.melody.size()){
                String cur = compareMelody.get(index);

                if(info.melody.get(compare).equals(cur)){
                    index++;
                    compare++;
                    count++;
                }
                else {
                    nextCompare++;
                    compare = nextCompare;
                    index = 0;
                    count = 0;
                }

                if(count == compareMelody.size()){
                    check = true;
                    break;
                }
            }

            if(check){
                result.add(info);
            }
        }
    }
}
