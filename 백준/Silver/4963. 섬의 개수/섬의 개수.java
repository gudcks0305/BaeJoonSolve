
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public
class Main {
    //상하 좌우 좌윗대 우윗대  좌하대 우 하대
    static int[] moveH = {-1,1,0,0,-1,1,-1,1};
    static int[] moveW = {0,0,-1,1,-1,-1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] wh = br.readLine().split(" ");
            int w = Integer.parseInt(wh[0]);
            int h = Integer.parseInt(wh[1]);
            if (w == 0 && h == 0) break;
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                String[] arr = br.readLine().split(" ");
                for (int k = 0; k < w; k++) {
                    if (arr[k].equals("1")) map[i][k] = 1;
                }
            }
            boolean[][] visited = new boolean[h][w];
            Queue<int[]> queue = new LinkedList<>();

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int k = 0; k < w; k++) {
                    if (!visited[i][k] && map[i][k] == 1) {
                        queue.add(new int[]{i,k});
                        while (!queue.isEmpty()){
                            int[] cur = queue.poll();
                            for (int j = 0; j < moveH.length; j++){
                                int nextH = cur[0] + moveH[j];
                                int nextW = cur[1] + moveW[j];
                                if(nextH < 0 || nextH >= h || nextW < 0 || nextW >= w) continue;
                                if (!visited[nextH][nextW] && map[nextH][nextW] == 1) {
                                    visited[nextH][nextW] = true;
                                    queue.add(new int[]{nextH , nextW});
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
