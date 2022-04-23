import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(nCk(b, a));
        }
    }
    // nCk
    public static long nCk(int n, int k){
        long result = 1;
        for(int i = 1; i <= k; i++){
            result *= n - k + i;
            result /= i;
        }
        return result;
    }












}
