import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        st = new StringTokenizer(br.readLine()," ");
        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n-1; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n-1; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if (sum<=m && sum > result) result = sum;
                }
            }
        }
        System.out.println(result);


    }


}
