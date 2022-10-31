
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        System.out.println(nQueen(arr, 0));
    }

    static int nQueen(int[][] arr, int depth){
        if(depth == arr.length){
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(isPossible(arr, depth, i)){
                arr[depth][i] = 1;
                count += nQueen(arr, depth + 1);
                arr[depth][i] = 0;
            }
        }
        return count;
    }

    static boolean isPossible(int[][] arr, int x, int y){
        // 세로 체크
        for (int i = 0; i < x; i++){
            if(arr[i][y] == 1){
                return false;
            }
        }
        // 대각선 체크
        for (int i = 1; i <= x; i++){
            if(y - i >= 0 && arr[x - i][y - i] == 1){
                return false;
            }
            if(y + i < arr.length && arr[x - i][y + i] == 1){
                return false;
            }
        }
        return true;
    }
}
