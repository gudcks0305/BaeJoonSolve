import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static boolean[][] visited;
    static int[][] box;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());


            }
        }


        System.out.println(bfs());




    }
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int cnt= 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
                if(box[i][j] == 0) cnt++;
            }
        }

        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (box[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny ,cur[2]+1});
                    visited[nx][ny] = true;
                    box[nx][ny] = cur[2]+1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(box[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, box[i][j]);
            }
        }
        if(cnt == 0) return 0;
        return max;
    }

    public static void print(int[][] arr, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }




}





