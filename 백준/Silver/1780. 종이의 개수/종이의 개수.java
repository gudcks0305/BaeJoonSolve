import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int GRAY = 0;		// -1에 해당
    public static int WHITE = 0;	// 0에 해당
    public static int BLACK = 0;	// 1에 해당
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        // 행렬 데이터 입력 받기
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        // 행렬 데이터 확인
        //printMatrix(arr);

        recursionDivide( 0, 0 , N);
        System.out.println(GRAY);
        System.out.println(WHITE);
        System.out.println(BLACK);

    }
    // 행렬 나눌 때
    //row : 행 시작 점, col : 열 시작점
    public static void recursionDivide( int row , int col , int size) {
        if(checkSameValue( row, col ,size)) {
            if(arr[row][col] == -1) {
                GRAY++;
            }
            else if(arr[row][col] == 0) {
                WHITE++;
            }
            else {
                BLACK++;
            }
            return;

        }

        int newSize = size / 3;

        recursionDivide( row, col , newSize); // 왼쪽 위
        recursionDivide(row, col + newSize, newSize); // 중간 위
        recursionDivide( row, col + 2 * newSize, newSize); // 오른쪽 위

        recursionDivide( row + newSize, col, newSize); // 왼쪽 중간
        recursionDivide(row + newSize, col + newSize, newSize); // 중간 중간
        recursionDivide( row + newSize, col + 2 * newSize, newSize); // 오른쪽 중간

        recursionDivide( row + 2 * newSize, col, newSize); // 왼쪽 오른쪽
        recursionDivide( row + 2 * newSize, col + newSize, newSize); // 중간 오른쪽
        recursionDivide( row + 2 * newSize, col + 2 * newSize, newSize); // 오른쪽 오른쪽



    }

    public static void printMatrix(int[][] arr) {
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }
    public static boolean checkSameValue( int row , int col, int newSize) {
        int color = arr[row][col];
        boolean check = true;
        for (int i = row; i < row + newSize; i++) {
            for (int j = col; j < col + newSize; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return check;
    }
}