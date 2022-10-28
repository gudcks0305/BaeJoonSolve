
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      int[] dp = new int[n];
      String[] s = br.readLine().split(" ");
      for (int i = 0 ; i < arr.length; i++){
         arr[i] = Integer.parseInt(s[i]);
      }
      dp[0] = arr[0];
      for(int i = 1; i < dp.length; i++){
         dp[i] = Math.max(arr[i], dp[i-1]+ arr[i]);
      }
      System.out.println(Arrays.stream(dp).max().getAsInt());
   }
}
