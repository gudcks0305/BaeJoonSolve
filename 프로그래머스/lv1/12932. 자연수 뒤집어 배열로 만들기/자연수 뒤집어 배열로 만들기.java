import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(long n) {
        List<Integer> result = Arrays.stream(String.valueOf(n).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(result);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}