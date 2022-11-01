

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] originArr;
    static int max = 0;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // 0 == 빈칸 , 1 == 벽 , 2 == 바이러스
        // 3개의 벽을 세워야함
        // 바이러스는 상하좌우로 퍼짐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = wh[0];
        int w = wh[1];
        originArr = new int[h][w];
        for (int i = 0; i < h; i++){
            originArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        combination(originArr , 0 , new int[3][2] , new boolean[h][w]);
        System.out.println(max);
    }
    public static void combination(int[][] arr , int depth , int[][] combi ,boolean[][] visited){
        if(depth == 3){
            int[][] copyArr = copyArr(arr);
            for (int i = 0; i < combi.length; i++){
                copyArr[combi[i][0]][combi[i][1]] = 1;
            }
            solution(copyArr);
            return;
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    combi[depth][0] = i;
                    combi[depth][1] = j;
                    visited[i][j] = true;
                    combination(arr , depth+1 , combi,visited);
                    visited[i][j] = false;

                }
            }
        }


    }
    public static void spreadVirus(int[][] copyArr , int x , int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x , y});
        while (!queue.isEmpty()){
            int[] virus  = queue.poll();
            for (int i = 0; i < 4; i++){
                int nextX = virus[0] + moveX[i];
                int nextY = virus[1] + moveY[i];
                if(nextX >= 0 && nextX < copyArr.length && nextY >= 0 && nextY < copyArr[0].length){
                    if(copyArr[nextX][nextY] == 0){
                        copyArr[nextX][nextY] = 2;
                        queue.add(new int[]{nextX , nextY});
                    }
                }
            }
        }
    }
    public static void solution(int[][] copyArr){

        for (int i = 0; i < copyArr.length; i++){
            for (int j = 0; j < copyArr[0].length; j++){
                if(copyArr[i][j] == 2){
                    spreadVirus(copyArr, i, j);
                }
            }
        }
        int safeArea = countSafeArea(copyArr);
        max = Math.max(max, safeArea);
    }
    private static int[][] copyArr(int[][] arr){
        int[][] copyArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++){
            System.arraycopy(arr[i], 0, copyArr[i], 0, arr[0].length);
        }
        return copyArr;
    }
    public static int countSafeArea(int[][] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}
