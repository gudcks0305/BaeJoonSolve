import java.util.*;
class Solution {
    static final int CACHE_HIT = 1;
   static final int CACHE_MISS = 5;
   public  int solution(int cacheSize, String[] cities) {
       if(cacheSize == 0) return CACHE_MISS * cities.length;
        int answer = 0;
      Queue<String> cache = new LinkedList<>();
       for (String s : cities) {
           String city = s.toLowerCase();
           if(cache.remove(city)){
               cache.add(city);
               answer += CACHE_HIT;

               // cache miss
           } else {
               answer += CACHE_MISS;
               if (cache.size() == cacheSize) {
                    cache.poll();
               }
               cache.add(city);
           }

       }
      return answer;
   }
}