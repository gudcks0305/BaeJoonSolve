
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> wine = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wine.add(Integer.parseInt(br.readLine()));
        }

        dp = new int[n];
        dp[0] = wine.get(0);
        if (n > 1) {
            dp[1] = wine.get(0) + wine.get(1);
        }
        if (n > 2) {
            dp[2] = Math.max(dp[1], Math.max(wine.get(0) + wine.get(2), wine.get(1) + wine.get(2)));
        }
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine.get(i), dp[i - 3] + wine.get(i - 1) + wine.get(i)));
        }
        System.out.println(dp[n - 1]);
    }
}
