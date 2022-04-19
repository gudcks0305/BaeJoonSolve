import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> idxmap = new HashMap<>();
        Map<String,HashSet<String>> map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            idxmap.put(id_list[i],i);
            map.put(id_list[i], new HashSet<>());
        }
        
        for(String s : report){
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }
        
         for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idxmap.get(name)]++;
                }
            }
        }
        return answer;
    }
}