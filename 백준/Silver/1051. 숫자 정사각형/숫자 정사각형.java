import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int length = Math.min(n, m);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        while (length > 1) {
            for (int i = 0; i < n - length + 1; i++) {
                for (int j = 0; j < m - length + 1; j++) {
                    if (arr[i][j] == arr[i][j + length - 1] && arr[i][j] == arr[i + length - 1][j] && arr[i][j] == arr[i + length - 1][j + length - 1]) {
                        System.out.println(length * length);
                        return;
                    }
                }
            }
            length--;
        }
        System.out.println(1);


    }


}








