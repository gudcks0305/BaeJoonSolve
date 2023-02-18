import java.util.*;
class Solution {
    public int solution(int[] topping) {
       Map<Integer, Integer> brother = new HashMap<>();
        Map<Integer, Integer> sister = new HashMap<>();
        int result = 0;
        for (int i = 0; i < topping.length; i++) {
            sister.put(topping[i], sister.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = 0; i < topping.length; i++) {
            int cur = topping[i];
            if (brother.containsKey(cur)) {
                brother.put(cur, brother.get(cur) + 1);
            } else {
                brother.put(cur, 1);
            }
            sister.put(cur, sister.get(cur) - 1);
            if (sister.get(cur) == 0) {
                sister.remove(cur);
            }
            if (sister.size() == brother.size()) result++;
        }
        return result;
    }
}