import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> nameYearn = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            nameYearn.put(name[i],yearning[i]);
        }
        for(int i = 0 ; i < photo.length; i++){
            int yearn = 0;
            for(int j = 0 ; j < photo[i].length; j++){
                if(nameYearn.containsKey(photo[i][j])){
                    yearn += nameYearn.get(photo[i][j]);
                }
            }
            result.add(yearn);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}