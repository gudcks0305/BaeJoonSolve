
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        for(int i = 0, s = r1; i < r2 -r1 +1; i++,s++){
            for(int j = 0, t = c1; j < c2 - c1 +1; j++, t++){
                int x = s % (2 * n - 1);
                int y = t % (2 * n - 1);
                int dis = Math.abs(n-1-x) + Math.abs(n-1-y);
                if(dis >= n) System.out.print(".");
                else System.out.print( Character.toString((dis % 26) + 'a') );
            }
            System.out.println();
        }


    }



}