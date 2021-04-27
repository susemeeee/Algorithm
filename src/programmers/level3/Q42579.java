/*
 * Q42579.java
 * Author : 박찬형
 * Created Date : 2021-04-27
 */
package programmers.level3;

import java.util.*;

public class Q42579 {
    class Music{
        public String genre;
        public int play;

        public Music(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
    }

    class Play{
        public int play;
        public int index;

        public Play(int play, int index){
            this.play = play;
            this.index = index;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Play>> playMap = new HashMap<>();
        Map<String, Integer> playSumList = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if (!playMap.containsKey(genres[i])){
                playMap.put(genres[i], new PriorityQueue<>((o1, o2) -> o2.play - o1.play));

            }
            playMap.get(genres[i]).add(new Play(plays[i], i));
            if(!playSumList.containsKey(genres[i])){
                playSumList.put(genres[i], plays[i]);
            }
            else{
                playSumList.replace(genres[i], playSumList.get(genres[i]) + plays[i]);
            }
        }

        Queue<Music> rank = new PriorityQueue<>((o1, o2) -> o2.play - o1.play);
        for(Map.Entry<String, Integer> entry : playSumList.entrySet()){
            rank.add(new Music(entry.getKey(), entry.getValue()));
        }

        List<Integer> list = new ArrayList<>();
        while(!rank.isEmpty()){
            Music music = rank.poll();
            for(int i = 0; i < 2 && !playMap.get(music.genre).isEmpty(); i++){
                Play play = playMap.get(music.genre).poll();
                list.add(play.index);
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(Integer i : list){
            answer[index++] = i;
        }
        return answer;
    }
}
