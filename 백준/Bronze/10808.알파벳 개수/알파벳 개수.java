import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) -'a']++ ;
        }
        for (int val: arr
             ) {
            System.out.print(val+ " ");
        }


    }


}