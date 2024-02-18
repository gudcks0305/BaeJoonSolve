import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N, M;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    char[][] arr = new char[N][M];
    boolean[][] visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        arr[i][j] = str.charAt(j);
      }
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          cnt++;
          dfs(arr, visited, i, j, N, M);
        }
      }
    }
    System.out.println(cnt);
  }
  public static void dfs(char[][] arr, boolean[][] visited, int x, int y, int N, int M) {
    visited[x][y] = true;
    if(arr[x][y] == '-'){
      if(y+1 < M && !visited[x][y+1] && arr[x][y+1] == '-'){
        dfs(arr, visited, x, y+1, N, M);
      }
      if (y-1 >= 0 && !visited[x][y-1] && arr[x][y-1] == '-'){
        dfs(arr, visited, x, y-1, N, M);
      }
    }else if(arr[x][y] == '|'){
      if(x+1 < N && !visited[x+1][y] && arr[x+1][y] == '|'){
        dfs(arr, visited, x+1, y, N, M);
      }
      if (x-1 >= 0 && !visited[x-1][y] && arr[x-1][y] == '|'){
        dfs(arr, visited, x-1, y, N, M);
      }
    }

  }



}