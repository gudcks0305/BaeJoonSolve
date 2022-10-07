import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public  int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 해쉬 테이블에서 다 합한다?
        HashMap<String, Integer> treeMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if(treeMap.containsKey(genres[i])){
                treeMap.put(genres[i], treeMap.get(genres[i]) + plays[i]);
            }else{
                treeMap.put(genres[i], plays[i]);
            }
        }
        List<Map.Entry<String,Integer>> sorted = new ArrayList<>(treeMap.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        ArrayList<Integer> result = new ArrayList<>();
        for (String s : sorted.stream().map(Map.Entry::getKey).collect(Collectors.toList())) {
            // 장르별로 정렬
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(s)){
                    list.add(i);
                }
            }
            list.sort((o1, o2) -> {
                if(plays[o1] == plays[o2]){
                    return o1 - o2;
                }else{
                    return plays[o2] - plays[o1];
                }
            });
            for (int i = 0; i < list.size(); i++) {
                if(i == 2){
                    break;
                }
                result.add(list.get(i));
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}