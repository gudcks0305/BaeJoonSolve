import java.util.*;
class Solution {
     public long solution(int n, int[] works) {
        // 최대 힙 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < works.length;i++){
            pq.add(works[i]);
        }
        while(n > 0){
            int max = pq.poll();
            if(max == 0) break;
            pq.add(max-1);
            n--;
        }
        long answer = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += Math.pow(num,2);
        }
          return answer;
    }
}