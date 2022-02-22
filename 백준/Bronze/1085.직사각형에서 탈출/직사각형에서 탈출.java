import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] val = {w-x,x,h-y,y};
        int min = w-x;
        for (int i = 1; i < 4; i++) {
            min = compare(min ,val[i]);
        }
        System.out.println(min);


    }

    static int compare(int a, int b) {
        if(a > b) return b;
        return a;
    }
}