import java.util.*;
class Solution {
    public int solution(int[][] routes) {
         int answer = 0;
        // routes 에서 int[i][1] 을 기준으로 정렬한다.

          Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        System.out.println(Arrays.deepToString(routes));
        // while routes 가 빌때까지 반복한다.
        int cam = -30001;
        for (int[] route : routes) {
            // routes 의 min 을 구한다.
            if (cam < route[0]) {
                cam = route[1];
                answer++;
            }
            // routes 의 min 보다 작은 값이 있으면 제거한다.e break;
        }
      return answer;
        
    }
}