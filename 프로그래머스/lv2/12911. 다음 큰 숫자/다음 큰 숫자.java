import java.util.Arrays;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        int next = n + 1;
        while (true) {
            String nextBinaryString = Integer.toBinaryString(next);
            int nextCount = 0;
            for (int i = 0; i < nextBinaryString.length(); i++) {
                if (nextBinaryString.charAt(i) == '1') {
                    nextCount++;
                }
            }
            if (count == nextCount) {
                answer = next;
                break;
            }
            next++;
        }
        return answer;
    }
}