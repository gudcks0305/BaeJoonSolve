import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] visited ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == 'R') {
                    arr[i][j] = 1;
                } else if (s.charAt(j) == 'G') {
                    arr[i][j] = 0;
                } else if (s.charAt(j) == 'B') {
                    arr[i][j] = -1;
                }
            }
        }
        int cnt = startBfs();
        System.out.println(cnt);
       //
        changeColor();

        cnt = startBfs();
        System.out.println(cnt);
      //  arrColor();

    }

    private static void changeColor() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
        Arrays.stream(visited).forEach(a -> Arrays.fill(a, 0));
    }

    static void bfs(int x , int y, int rgb) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length) continue;
                if (visited[nx][ny] == 1) continue;
                if (arr[nx][ny] == rgb) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }
    public static int startBfs() {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, arr[i][j]);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean checkVisited(int x, int y) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr.length) return false;
        return visited[x][y] == 1;
    }
    public static void arrColor(){
        Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
    }









}