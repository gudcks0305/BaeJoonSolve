import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();
        final int bong3 = 3;
        final int bong5 = 5;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N > 0){
            if((N % 5 == 3 && N != 3) || N % 5 == 0){
                N -= 5;
                result++;
            }else{
                N -= 3;
                result++;
            }

        }
        if(N < 0 ) System.out.println(-1);
        else System.out.println(result);
    }
}
/*
2 4
7 3 1 8
3 3 3 4
*/
