class Solution {
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for(int i = 0 ; i < puddles.length;i++){
            int x = puddles[i][1];
            int y = puddles[i][0];
            dp[x][y] = -1;
        }
        int result = dp(m , n);
        return result;
    }
    
    public int dp(int m, int n){
        // 종료 조건 ?
        // 0 이 아니면 리턴?
        // dp[n][m] == -1 이면 리턴 0;
        // m == 1 | n == 1
        if(m <= 0 || n <= 0 || dp[n][m] == -1) return 0;
        if(dp[n][m] != 0) return dp[n][m];
        
        dp[n][m] = (dp(m,n-1) + dp(m-1,n)) % 1000000007;
        return dp[n][m];

    }
}