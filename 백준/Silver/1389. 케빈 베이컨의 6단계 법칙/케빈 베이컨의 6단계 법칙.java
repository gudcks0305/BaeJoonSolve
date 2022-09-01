import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 케빈 베이컨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        // 케빈 베아컨
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                sum += bfs(i, j);
            }
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);


    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[arr.length];
        q.add(start);
        visit[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == end) return cnt;
                for (int j = 1; j < arr.length; j++) {
                    if (arr[cur][j] == 1 && !visit[j]) {
                        q.add(j);
                        visit[j] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }




}