
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int answerSeconds = Integer.MAX_VALUE; // 시간
        int answerHeight = -1; // 층

        for (int i = min; i <= max; i++) { // 최소층 부터 최대층 까지

            int seconds = 0;
            int inventory = b;

            for (int[] ints : map) {
                for (int anInt : ints) {
                    int diff = anInt - i;

                    if (diff > 0) { // 제거해야 함
                        seconds += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) { // 추가해야 함
                        seconds += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }


            if(inventory >= 0) {
                if(seconds <= answerSeconds) { // == 가 포함되어야 함 ㅇ그렇지 않으면 최대 높이를 판별 하지 못함
                    answerSeconds = seconds;
                    answerHeight = i;
                }
            }
        }
        System.out.println(answerSeconds + " " + answerHeight);



    }

}