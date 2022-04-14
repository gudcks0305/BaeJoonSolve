import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    // 상 하 좌 우 순서
    static int cnt = 0;
    static int[][] arr;
    static int[] check;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;//= new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        check = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[k][l] = 1;
            arr[l][k] = 1;
        }
        dfs(1);
        System.out.print(cnt);
    }
    static void dfs(int x) {
        check[x] = 1;
        for (int i = 1; i <= n; i++) {
            if (arr[x][i] == 1 && check[i] == 0) {
                dfs(i);
                cnt++;
            }
        }
    }
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        check[x] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[cur][i] == 1 && check[i] == 0) {
                    q.offer(i);
                    check[i] = 1;
                }
            }
        }
    }
}








