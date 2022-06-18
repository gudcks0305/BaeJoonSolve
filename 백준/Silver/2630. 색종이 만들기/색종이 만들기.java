import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int white = 0;
    static int blue =  0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        recursion(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }
    public static void recursion(int x, int y, int size) {

        if(checkColor(x, y, size) == 1) {
            
            blue++;
            return;
        }else if(checkColor(x, y, size) == 0) {
           
            white++;
            return;
        }
        int resize = size / 2;
        if(resize == 0) {
            return;
        }
        if(resize>0) {
            recursion(x, y, resize);
            recursion(x + resize, y, resize);
            recursion(x, y + resize, resize);
            recursion(x + resize, y + resize, resize);

        }


    }
    public static int checkColor(int x, int y , int size) {

        if (size == 1) {
            return map[x][y];
        }

        int color = map[x][y];
        for (int i = x; i < x+ size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    return -1;
                }
            }
        }
        return color;
    }
    public static void printMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }














}