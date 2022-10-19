
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(intArr);
        int m = Integer.parseInt(br.readLine());
        int[] intArr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m; i++) {
            int search = Arrays.binarySearch(intArr, intArr2[i]);
            if (search >= 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }


    }
}
