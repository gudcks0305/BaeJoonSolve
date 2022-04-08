import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int[][] map = new int[1001][1001];
        boolean[] visited = new boolean[1001];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }


        dfs(map, visited, v);

        sb.append("\n");
        visited = new boolean[1001];

        bfs(map, visited, v);

        System.out.println(sb.toString());


    }
    public static void dfs(int[][] map, boolean[] visited, int v) {
        visited[v] = true;
        sb.append(v + " ");
        for(int i = 1; i <= 1000; i++) {
            if(map[v][i] == 1 && !visited[i]) {
                dfs(map, visited, i);
            }
        }
    }
    public static void bfs(int[][] map, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        sb.append(v + " ");
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int i = 1; i <= 1000; i++) {
                if(map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }


}





