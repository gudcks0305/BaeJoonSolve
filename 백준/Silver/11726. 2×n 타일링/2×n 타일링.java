import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    static long[] dp = new long[1001];

    public static void main(String[] args) throws IOException {
        //2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 0 -> 총 0
        // 1 -> 총 1
        // 2 -> 11 , 2 총 2
        // 3 ->
        // 1 1 1 -> 1
        // 1 2 ->2
        // 총 3개
        // 4 ->
        // 1 1 1 1
        // 1 1 2 -> 3
        // 2 2
        // 5 ->
        // 1 1 1 1 1 // 1개
        // 1 1 1 2  // 4개
        // 1 2 2 -> 3개  총 8개
        // nC0 ~ nCn 의 합? n을 1을 선택 하는 것이라고 쳤을 때
        // n의 경우
        // 짝수 : nC0 , nC2 , nC4 ...
        // 홀수 : nC1 , nC3 , nC5...
        System.out.println(dp(n) % 10007);


    }
    static long dp(int n){

        if(dp[n] != 0) return dp[n];
        if(n == 1) return 1;
        if(n == 2) return 2;
        dp[n] = (dp(n-1) + dp(n-2)) % 10007;
        return dp[n];
    }


}
