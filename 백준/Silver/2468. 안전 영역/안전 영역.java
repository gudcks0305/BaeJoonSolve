import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            max = Math.max(max, Arrays.stream(maps[i]).max().getAsInt());

        }
        //System.out.println(max);
        for (int i = 0; i <= max; i++) {
            MAX = Math.max(bfs(maps, i), MAX);
        }
        System.out.println(MAX);
    }

    public static int bfs(int[][] map, int rainQuan) {
        boolean[][] visited = new boolean[map.length][map.length];
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j] && map[i][j] > rainQuan) {
                    bfs(map, visited, i, j, rainQuan);
                    cnt++;
                }
            }
        }
        //System.out.println(cnt);
        return cnt;
    }

    public static int[] moveX = {-1, 1, 0, 0};
    public static int[] moveY = {0, 0, -1, 1};

    public static void bfs(int[][] map, boolean[][] visited, int startY, int startX, int rainQuan) {
        Queue<int[]> rain = new LinkedList<>();
        rain.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        while (!rain.isEmpty()) {
            int[] cur = rain.poll();
            int curY = cur[0];
            int curX = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextY = curY + moveY[i];
                int nextX = curX + moveX[i];
                if(!isValid(map , nextY ,nextX)) continue;
                if(visited[nextY][nextX]) continue;
                if(map[nextY][nextX] > rainQuan){
                    rain.add(new int[]{nextY , nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
    public static boolean isValid(int[][] arr , int Y , int X){
        return arr.length > Y && Y >= 0 && X >= 0 && arr.length > X ;
    }
}
