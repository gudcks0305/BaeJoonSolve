import java.util.*;
class Solution {
    static int[][] dp;
    int solution(int[][] land) {
        int answer = 0;
        dp = new int[land.length][land[0].length];
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int i = 0; i < land[0].length; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1 ; i < land.length; i++){
            // dp 로 메모라이제이션
            for(int j = 0; j < land[i].length; j++){
                for(int k = 0; k < land[i].length; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][k] + land[i][j]);
                }
            }
        }
        int max = Arrays.stream(dp[dp.length-1]).max().getAsInt();
        return max;
    }
}