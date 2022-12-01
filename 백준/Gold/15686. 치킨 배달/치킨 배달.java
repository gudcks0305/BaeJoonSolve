
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        List<Integer[]> chicken = new ArrayList<>();
        List<Integer[]> house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    house.add(new Integer[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new Integer[]{i, j});
                }
            }
        }
        boolean[] openChicken = new boolean[chicken.size()];
        int min = dfs(house, chicken, openChicken, 0, 0, m);
        System.out.println(min);
    }

    public static int getDistance(Integer[] house, Integer[] chicken) {
        return Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
    }

    public static int getMinDistance(List<Integer[]> house, List<Integer[]> chicken, boolean[] openChicken) {
        int sum = 0;
        for (Integer[] h : house) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (openChicken[i]) {
                    min = Math.min(min, getDistance(h, chicken.get(i)));
                }
            }
            sum += min;
        }
        return sum;
    }

    public static int dfs(List<Integer[]> house, List<Integer[]> chicken, boolean[] openChicken, int index, int count, int m) {
        if (count == m) {
            return getMinDistance(house, chicken, openChicken);
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i < chicken.size(); i++) {
            openChicken[i] = true;
            min = Math.min(min, dfs(house, chicken, openChicken, i + 1, count + 1, m));
            openChicken[i] = false;
        }
        return min;
    }
}
