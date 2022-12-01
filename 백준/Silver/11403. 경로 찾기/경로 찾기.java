
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];
        for (int i = 0; i < N; i++){
           arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < N; i++){
           for(int j = 0; j < N; j++){
              for (int k = 0; k < N; k++){
                 if(arr[j][i] == 1 && arr[i][k] == 1){
                    arr[j][k] = 1;
                 }
              }
           }
        }
       for (int[] ints : arr) {
          for (int anInt : ints) {
             System.out.print(anInt + " ");
          }
          System.out.println();
       }
    }

}

