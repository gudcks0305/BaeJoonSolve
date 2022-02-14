import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] k = br.readLine().split(" ");
            int a = Integer.parseInt(k[0]);
            int b = Integer.parseInt(k[1]);
            int re = gcd(a, b);
            System.out.println(a*b /re);
        }


    }
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }


}