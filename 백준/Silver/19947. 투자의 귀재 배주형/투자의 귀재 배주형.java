import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] dp = new long[m+1];
        dp[0] = n;
        for(int i=1;i<=m;i++) {

            dp[i] = (long) (dp[i-1] * 1.05);
            if(i>=3){
                dp[i] = (long) Math.max(dp[i], dp[i-3] * 1.2);
            }
            if(i>=5){
                dp[i] = (long)Math.max(dp[i], dp[i-5] * 1.35);
            }
        }
        System.out.println(dp[m]);

    }







}








