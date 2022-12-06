import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Set<String> set = new HashSet<>();
        for (String[] cloth : clothes) {
            set.add(cloth[1]);
        }
        System.out.println(set);
        List<String> list = new ArrayList<>(set);
        int[] count = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (String[] cloth : clothes) {
                if (list.get(i).equals(cloth[1])) {
                    count[i]++;
                }
            }
        }
        int answer = 1;
        for (int i = 0; i < count.length; i++) {
            answer *= (count[i] + 1);
        }
        return answer - 1;
    }
}