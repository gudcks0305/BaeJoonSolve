import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int solution(int left, int right) {
        int[] arr = IntStream.range(left,right+1).toArray();
        Map<Integer, Integer> yacksu = new HashMap<>();
        for (int k : arr) {
            int cnt = 0;
            for (int j = 1; j <= k; j++) {
                if (k % j == 0) cnt++;
            }
            yacksu.put(k, cnt);
        }
        int answer = 0;
        for (Map.Entry<Integer, Integer> entrySet : yacksu.entrySet()) {
            if(entrySet.getValue() % 2 == 0) answer += entrySet.getKey();
            else answer -= entrySet.getKey();
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
        System.out.print(answer);
        return answer;
    }
}