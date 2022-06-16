import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
        }
        System.out.println(sum);
        // 최대 2의 개수


    }
    // 시작 행 // 시작 열 // 행 크기




}