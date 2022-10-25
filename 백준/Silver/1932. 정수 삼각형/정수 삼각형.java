import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
   static int[][] dp;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      dp = new int[n][];
      for (int i = 0 ; i < n; i++){
         int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         dp[i] = arr;
      }
      for (int i = 1 ; i < dp.length; i++){
         // 대각선 중에서 가장 큰 값 가져와서 더하기
         // 현재 위치를 p 라고 할 때
         // 대각선의 위치는?
         // p - 1 이랑 p
         // arr 범위 체크
         for (int k = 0; k < dp[i].length; k++){
            if(k-1 >= 0 && k < dp[i].length - 1){
                dp[i][k] += Math.max(dp[i-1][k] , dp[i-1][k-1]);
            }else if(k == 0){
               dp[i][k] += dp[i-1][k];
            }else{
               dp[i][k] += dp[i-1][k-1];
            }
         }
      }
      int max = Arrays.stream(dp[n-1]).max().getAsInt();
      System.out.println(max);
   }
}
