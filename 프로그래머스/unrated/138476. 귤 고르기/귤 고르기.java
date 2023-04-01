import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> tanger = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            if(!tanger.containsKey(tangerine[i])){
                tanger.put(tangerine[i] , 1);
            }
            else{
                tanger.put(tangerine[i] , tanger.get(tangerine[i]) + 1);
            }            
        }
        List<Integer> values = new LinkedList<>(tanger.values());
        Collections.sort(values , (o1,o2) -> o2 - o1 );
        int cur = 0;
        for(int i = 0 ; i < values.size(); i++){
            if(cur >= k) break;
            cur+= values.get(i);
            answer++;
        }
        return answer;
    }
}