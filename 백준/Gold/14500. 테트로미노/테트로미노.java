import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] visited ;
    static int max;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = 1;
                dfs(i, j, 0, 0);
                visited[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check(i, j, n, m);
            }
        }
        System.out.println(max);



    }
    static void dfs(int x, int y , int depth , int sum) {

       if(depth>=4) {
           max = Math.max(max, sum);
           return;
       }

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                continue;
            }
            if (visited[nx][ny] == 1) {
                continue;
            }
            visited[nx][ny] = 1;
            dfs(nx, ny, depth + 1, sum + arr[nx][ny]);

            visited[nx][ny] = 0;
        }


    }
    static void check(int x, int y , int N , int M) {
        if (x < N - 2 && y < M - 1)
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y + 1]);

        if (x < N - 2 && y > 0)
            max = Math.max(max, arr[x][y] + arr[x + 1][y] + arr[x + 2][y] + arr[x + 1][y - 1]);

        if (x < N - 1 && y < M - 2)
            max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1]);

        if (x > 0 && y < M - 2)
            max = Math.max(max, arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x - 1][y + 1]);
    }













}