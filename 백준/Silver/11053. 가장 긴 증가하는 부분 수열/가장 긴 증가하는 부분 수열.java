
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String str = br.readLine();
        String[] strArr = str.split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int output = longestIncreasingSubsequence(arr);
        System.out.println(output); // --> 5

    }


    private static int longestIncreasingSubsequence(int[] ints) {

        int[] dp = new int[ints.length];
        Arrays.fill(dp, 1);
        // 증가하는 부분 수열의 크기 구하기
        int max = 0;
        for(int i = 0; i < ints.length; i++){
            for(int j = 0; j < i; j++){
                // i번째 수가 j번째 수보다 크다면
                if(ints[i] > ints[j]){
                    // i번째 수열의 증가하는 부분 수열의 크기는 j번째 수열의 증가하는 부분 수열의 크기 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
