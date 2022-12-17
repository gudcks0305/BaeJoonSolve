import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        while (start <= end) {
            long disposePeople = 0;
            // mid는 현재 주어진 시간
            long mid = (start + end) / 2;
            // 주어진 시간으로 처리 할 수 있는 사람의 수
            for (int time : times) {
                disposePeople += mid/time;
            }
            // 주어진 시간으로 처리 할 수 있는 사람의 수가 n 보다 작으면 시간을 키워야 함
            if(disposePeople < n ){
                start = mid + 1;
            }else{
                // 주어진 시간으로 처리 할 수 있는 사람의 수가  n 보다 크거나 같으면 최소 값을 찾기 위해서 max로 주어진 시간을 반으로 줄인다.
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}