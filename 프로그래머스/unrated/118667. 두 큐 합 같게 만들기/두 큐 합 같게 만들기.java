import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        // initialize
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        // 횟수
        int cnt = 0;

        // 누적합
        long sum1 = q1.stream().mapToLong(i -> i).sum();
        long sum2 = q2.stream().mapToLong(i -> i).sum();

        // 두 배열 원소들의 합을 나누기 2했을때 나머지가 1이면 결국 각 큐의 원소 합을 같게 만들 수 없다.
        if((sum1 + sum2) % 2 == 1) return -1;

        // 큐 한쪽이 작으면 큰 쪽에서 뽑아서 넣기.
        while (cnt < (queue1.length * 3)) {
            if (sum1 > sum2) {
                Integer poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                sum2 += poll;
                cnt++;
            } else if (sum2 > sum1) {
                Integer poll = q2.poll();
                q1.add(poll);
                sum2 -= poll;
                sum1 += poll;
                cnt++;
            } else { // sum1 == sum2
                return cnt;
            }
        }

        return -1;
    }
}