import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;//= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }


        }
        sort(arr, n);
        printArray(arr, n);
    }
    // function to sort the array ,first sorting element if the first element is same then sort the second element
    public static void sort(int[][] arr, int n) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
    }
    // function to print the array
    public static void printArray(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][0] + " " + arr[i][1] + " \n");
        }

    }
}





