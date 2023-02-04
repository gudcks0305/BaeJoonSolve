import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    protected static final int[] dy = {-1, 1, 0, 0};
    protected static final int[] dx = {0, 0, -1, 1};
    public int solution(int[][] maps) {
         int result = -1;
        // 시작 지점 좌표 Y , X , CNT
        int[] startPoint = {0, 0, 0};
        // 도착 지점 좌표
        int[] endPoint = {maps.length - 1, maps[0].length - 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        for (int[] map : maps){
            System.out.println(Arrays.toString(map));
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPoint);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curCount = cur[2];
            if (curX == endPoint[1] && curY == endPoint[0]) return curCount + 1;
            // 현재 위치에서 이동
            for (int i = 0; i < 4; i++) {
                int moveY = curY + dy[i];
                int moveX = curX + dx[i];
                int count = curCount + 1;
                // 벽은 안대!
                // 맵을 벗어나거나 방문했음 안대!
                if (!isValid(moveY, moveX, maps) || visited[moveY][moveX] || maps[moveY][moveX] == 0) {
                    continue;
                }
                queue.add(new int[]{moveY, moveX, count});
                visited[moveY][moveX] = true;
            }
        }

        return result;
    }
      public static boolean isValid(int y, int x, int[][] map) {
        return y >= 0 && x >= 0 && y < map.length && x < map[0].length;
    }
}