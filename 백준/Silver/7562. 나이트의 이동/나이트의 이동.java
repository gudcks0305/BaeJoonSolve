
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int I = Integer.parseInt(br.readLine());
            boolean[][] maps = new boolean[I][I];
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(bfs(maps, start, end));
        }
    }

    public static int bfs(boolean[][] maps, int[] start, int[] end) {
        Queue<int[]> knight = new LinkedList<>();
        knight.add(new int[]{start[0], start[1], 0});
        maps[start[0]][start[1]] = true;
        while (!knight.isEmpty()) {
            int[] cur = knight.poll();
            int curY = cur[0];
            int curX = cur[1];
            int moveCnt = cur[2];
            if(curY == end[0] && curX == end[1]) return moveCnt;
            for (int i = 0; i < 8; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if(!isVaild(maps , nextY , nextX)) continue;
                if(maps[nextY][nextX]) continue;
                knight.add(new int[]{nextY , nextX , moveCnt + 1});
                maps[nextY][nextX] = true;

            }
        }
      
        return -1;
    }

    public static boolean isVaild(boolean[][] maps, int nextY, int nextX) {
        //return maps.length > nextY && 0 <= nextY && nextX >= 0 && maps[0].length > nextX;
        return maps.length > nextY && 0 <= nextY && maps[0].length > nextX && 0 <= nextX;
    }
}
