import java.util.Arrays;
class Solution {
        static int MAX = 0;

    public int solution(int k, int[][] dungeons) {
        dp(dungeons, new boolean[dungeons.length], 0, 0, k);
        return MAX;
    }
    public static void dp(int[][] dungeons, boolean[] visited, int depth, int nums, int currentHP) {
        if (dungeons.length == depth) {
            MAX = Math.max(nums, MAX);
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int nextNum = nums;
            int nextHP = currentHP;
            if (currentHP >= dungeons[i][0]) {
                nextNum++;
                nextHP -= dungeons[i][1];
            }
            dp(dungeons, visited, depth + 1, nextNum, nextHP);
            visited[i] = false;
        }
    }
}