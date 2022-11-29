import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      long[] dp = new long[101];
      initializationDp(dp);
      while (n -- > 0){
         int K = Integer.parseInt(br.readLine());
         long result = solution(K - 1, dp);
         System.out.println(result);
      }
   }
   private static void initializationDp(long[] dp){
      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 1;
      dp[3] = 2;
      dp[4] = 2;
      dp[5] = 3;
      //dp[6] = 4;
   }
   private static long solution(int k , long[] dp) {
      if(k < 6) return dp[k];
      return dp(k , dp);
   }
   private static long dp(int n , long[] dp){
      if(dp[n] != 0) return dp[n];
      dp[n] = dp(n - 5 , dp) + dp(n-1 , dp);
      return dp[n];
   }
   // a0 = 1
   // a1 = 1
   // a2 = 1
   // a3 = a1 + a2
   // a4 = a3
   // a5 = a1 + a4
   // a6 = a0 + a5
   // a7 = a2 + a6
   // a8 = a3 + a7
   // a9 = a4 + a8
   // n >= 6 fn = f(n-5) + f(n-1);

}
