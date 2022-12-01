
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().chars().map(c -> c - '0').toArray();
        }
        System.out.println(bfs(map));
    }

    public static int bfs(int[][] map) {
        int startY = 0;
        int startX = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startY, startX, 1, 0});
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int count = poll[2];
            int breakWall = poll[3];
            if (y == map.length - 1 && x == map[0].length - 1) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = y + moveY[i];
                int nextX = x + moveX[i];
                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) {
                    continue;
                }

                if (map[nextY][nextX] == 1 && breakWall == 0 && !visited[nextY][nextX][1]) {
                    visited[nextY][nextX][1] = true;
                    queue.add(new Integer[]{nextY, nextX, count + 1, 1});
                }
                if (map[nextY][nextX] == 0 && !visited[nextY][nextX][breakWall]) {
                    visited[nextY][nextX][breakWall] = true;
                    queue.add(new Integer[]{nextY, nextX, count + 1, breakWall});
                }

            }
        }
        return -1;
    }

}
