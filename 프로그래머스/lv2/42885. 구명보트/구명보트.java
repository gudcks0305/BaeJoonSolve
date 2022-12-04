import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        for (int x : people) list.add(x);
        Collections.sort(list);

        // 꼭 사이즈 지정 필요
        ArrayDeque<Integer> dq = new ArrayDeque<>(50505);
        dq.addAll(list);

        int ans = 0;
        while (!dq.isEmpty()) {
            int weight = dq.pollLast();
            if (!dq.isEmpty() && weight + dq.peekFirst() <= limit) {
                dq.pollFirst();
            }
            ans++;
        }

        return ans;
    }
}