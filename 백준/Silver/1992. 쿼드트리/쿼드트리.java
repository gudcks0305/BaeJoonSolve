import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 최대 2의 개수

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        recursion(0 , 0 , n);
        System.out.println(sb.toString());
    }
    // 시작 행 // 시작 열 // 행 크기
    public  static void recursion(int x , int y , int size ){
        int checkValue = checkSame(x, y, size);
        if( checkValue == 1){
            sb.append("1");
            return;
        } else if (checkValue == 0) {
            sb.append("0");
            return;
        }

        int reSize = size / 2;
        if(reSize == 0){
            return;
        }
        if(reSize > 0){
            sb.append("(");
            recursion(x, y, reSize);
            recursion(x, y + reSize, reSize);
            recursion(x + reSize, y, reSize);
            recursion(x + reSize, y + reSize, reSize);
            sb.append(")");
        }
    }
    public static int checkSame(int x , int y , int size) {
        int check = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != check) {
                    return -1;
                }
            }
        }
        return check;
    }

}