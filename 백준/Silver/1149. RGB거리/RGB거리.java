
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
   static int N = 0;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      List<ArrayList<Integer>> pay = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         String[] s = br.readLine().split(" ");
         pay.add(new ArrayList<>());
         for(int j = 0; j < 3; j++){
            pay.get(i).add(Integer.parseInt(s[j]));
         }
      }
      System.out.println(solutionDp(pay));

   }
   public static int solutionDp(List<ArrayList<Integer>> pay){
      // TODO :
      // 1st Colors != 2ed Colors // 첫 번째 집 != 두 번째 집
      // Nth Colors != N-1 th Colors
      //When  2 <= i <= N - 1 ,  ( I - 1 ) Colors != ( I + 1 ) Colors
      // return paint min pay
       // index 0 = red , 1 = green , 2 = blue
        int[][] dp = new int[N][3];
        dp[0][0] = pay.get(0).get(0); // 0 번째 에서 red 선택한 경우
        dp[0][1] = pay.get(0).get(1); // 0 번째 에서 green 선택한 경우
        dp[0][2] = pay.get(0).get(2); // 0 번째 에서 blue 선택한 경우
        for(int i = 1; i < N; i++){
            // if i >=2 , i-1 th color != i+1 th color
            // i 번째 집에서 red 선택한 경우
           dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + pay.get(i).get(0);
           dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + pay.get(i).get(1);
           dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + pay.get(i).get(2);
        }
        return Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));



   }

}
