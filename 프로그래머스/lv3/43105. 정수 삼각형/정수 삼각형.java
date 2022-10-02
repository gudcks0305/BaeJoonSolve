class Solution {
   static int[][] dp = new int[501][501];
    public int solution(int[][] triangle) {
        dp[0][0] = triangle[0][0];
        int max = 0;
        for (int i = 0; i < triangle.length; i++) {
            int re = dp(triangle.length - 1, i, triangle);
            if (max <= re) {
                max = re;
            }
        }
        return max;
    }
    public int dp(int x, int y, int[][] triangle) {
        if (dp[x][y] != 0) return dp[x][y];
        if (y == 0) {
            dp[x][y] += triangle[x][y] + dp(x - 1, y, triangle);
        } else if (x == y) {
            dp[x][y] += triangle[x][y] + dp(x - 1, y - 1, triangle);
        } else {
            dp[x][y] += triangle[x][y] + Math.max(dp(x - 1, y - 1,triangle), dp(x - 1, y,triangle));
        }
        return dp[x][y];

    }
}