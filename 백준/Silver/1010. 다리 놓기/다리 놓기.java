import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Main {
    static int N = 0;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            // 서쪽 게이트 수 input[0]
            // 동쪽 게이트 수 input[1]
            int east = Integer.parseInt(input[0]);
            int west = Integer.parseInt(input[1]);
            int max = Math.max(east, west);
            int min = Math.min(east, west);
            System.out.println(dpBridge(max,min));
        }

    }
    // number of cases
    // nCr = n-1Cr-1 + n-1Cr
    public static int dpBridge(int max , int min) {
        if(max < 0 || min < 0) return 0;
        if(max == min) {
            dp[max][min] = 1;
            return 1;
        }
        if(dp[max][min] != 0) {
            return dp[max][min];
        }
        dp[max][min] = dpBridge(max-1,min-1) + dpBridge(max-1,min);
        return dp[max][min];

    }
}