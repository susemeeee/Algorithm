/*
 * Q17680.java
 * Author : 박찬형
 * Created Date : 2021-07-17
 */
package programmers.level2;

import java.util.*;

public class Q17680 {
    static class Cache{
        private final String city;
        private int recentUsed;

        public Cache(String city, int recentUsed){
            this.city = city;
            this.recentUsed = recentUsed;
        }

        public void update(int recentUsed){
            this.recentUsed = recentUsed;
        }
    }

    private List<Cache> cache;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }

        cache = new LinkedList<>();

        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase(Locale.ROOT);
            int index = containsCache(city);

            if(index >= 0){
                cache.get(index).recentUsed = i;
                answer++;
                continue;
            }
            else if(cache.size() < cacheSize){
                cache.add(new Cache(city, i));
            }
            else{
                cache.sort((o1, o2) -> o2.recentUsed - o1.recentUsed);
                cache.remove(cache.size() - 1);
                cache.add(new Cache(city, i));
            }
            answer += 5;
        }
        return answer;
    }

    private int containsCache(String city){
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).city.equals(city)){
                return i;
            }
        }

        return -1;
    }
}
