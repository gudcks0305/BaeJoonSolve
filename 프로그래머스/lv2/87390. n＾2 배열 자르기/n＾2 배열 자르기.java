import java.util.Arrays;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        long cur = 0;
        long row = 0;
        long col = 0;
        for (int i = 0; i < answer.length; i++) {
            row = left / n;
            col = left % n;
            answer[i] = (int) Math.max(row, col) + 1;
            left++;
        }
        return answer;
    }
}