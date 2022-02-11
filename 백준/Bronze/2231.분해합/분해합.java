import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int min=0;
        for (int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;
            while (number!=0){
                sum += number % 10;
                number /= 10;
            }
            if(sum + i == N){
                min =  i;
                break;
            }

        }
        System.out.println(min);

    }


}
