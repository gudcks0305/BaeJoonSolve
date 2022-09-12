import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            int r = (int) (Math.pow(r1 + r2, 2));
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (d == r || d == Math.pow(r1 - r2, 2)) {
                System.out.println(1);
            } else if (d > r || d < Math.pow(r1 - r2, 2)) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }


    }


}








