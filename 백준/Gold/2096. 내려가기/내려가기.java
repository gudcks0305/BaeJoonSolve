
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] board = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = scan.nextInt();
            }
        }

        int[][] minDp = new int[n + 1][3];
        int[][] maxDp = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];

            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[n][i]);
            max = Math.max(max, maxDp[n][i]);
        }
        System.out.println(max + " " + min);
    }

    public static int[] dx = {-1, 0, 1};
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;

    public static void recursion(int[][] maps, int depth, int startIdx, int result) {
        if (depth == maps.length - 1) {
            result += maps[depth][startIdx];
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }
        for (int i = 0; i < maps.length; i++) {
            int nextY = depth + 1;
            int nextX = startIdx + dx[i];
            if (validation(maps, nextX)) {
                recursion(maps, nextY, nextX, result + maps[depth][startIdx]);
            }
        }
    }

    public static boolean validation(int[][] maps, int nextIdx) {
        return maps.length - 1 >= nextIdx && nextIdx >= 0;
    }
}
