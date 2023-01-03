
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int distance;
    static int doneX;
    static int doneY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] maps = new int[inputs[0]][inputs[1]];
        boolean[][] visited = new boolean[inputs[0]][inputs[1]];
        distance = inputs[2];
        int startY = inputs[0] - 1;
        int startX = 0;
        doneX = maps[0].length - 1;
        doneY = 0;
        for (int i = 0; i < inputs[0]; i++) {
            String s = br.readLine();
            for (int j = 0; j < inputs[1]; j++) {
                if (".".equals(String.valueOf(s.charAt(j)))) maps[i][j] = 0;
                else maps[i][j] = 1;
            }
        }
        visited[startY][startX] = true;
        int result = dfs(maps, visited, startX, startY, 1);
        System.out.println(result);
    }

    // 이동 상하 좌우 근데 하는 필요없지?
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int dfs(int[][] maps, boolean[][] visited, int indexX, int indexY, int depth) {
        if (depth == distance) {
            if (doneX == indexX && doneY == indexY) {

                return 1;
            }
            return 0;
        }
        int result = 0;
        for (int i = 0; i < dy.length; i++) {
            int nextXIdx = indexX + dx[i];
            int nextYIdx = indexY + dy[i];
            if (validate(maps, nextYIdx, nextXIdx)) {
                if (maps[nextYIdx][nextXIdx] != 1 && !visited[nextYIdx][nextXIdx]) {
                    visited[nextYIdx][nextXIdx] = true;
                    result += dfs(maps, visited, nextXIdx, nextYIdx, depth + 1);
                    visited[nextYIdx][nextXIdx] = false;
                }
            }
        }
        return result;

    }

    static boolean validate(int[][] maps, int y, int x) {
        if (maps[0].length - 1 < x || x < 0 || maps.length - 1 < y || 0 > y) return false;
        return true;
    }

    static <T> void print(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
