import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

     static  int[][] arr;
     static  int cnt;
     static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            //가로길이
            int M = Integer.parseInt(st.nextToken());
            // 세로길이
            int N = Integer.parseInt(st.nextToken());
            // 배추 심어진 곳
            int K = Integer.parseInt(st.nextToken());
            // 초기화
            arr = new int[M][N];
            cnt = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            bfs();

        }

    }
    public static void bfs() {

        int[][] visited = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {

                    visited[i][j] = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] d : dir) {
                            int nx = cur[0] + d[0];
                            int ny = cur[1] + d[1];
                            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
                            if (visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                                visited[nx][ny] = 1;
                                arr[nx][ny] = 0;
                                q.add(new int[]{nx, ny});
                            }
                        }

                    }
                    cnt++;

                }

            }
        }
        System.out.println(cnt);
    }



}
