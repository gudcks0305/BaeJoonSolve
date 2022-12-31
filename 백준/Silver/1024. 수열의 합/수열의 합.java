
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] arg = br.readLine().split(" ");
      int N = Integer.parseInt(arg[0]);
      int L = Integer.parseInt(arg[1]);
      // 길이가 T 일 떄 N = T * X + T(T+1)/2
      // = T(X + (T+1)/2)
      // N / T  - (T+1)/2 = X;
      // 18 / 3 - 2 = X;
      int result = -1;
      List<Integer> resultList = new ArrayList<>();
      for (int i = L; i <= 100; i++){
         int searchX = (N / i) - (i - 1) / 2 ;
         if(searchX < 0) break;
         int sum = sum(searchX , i);
         //System.out.println("length : " + i   + " SearchX = " + searchX  + " sum = " + sum);
         if(sum == N) {
            for (int j = 0; j < i; j++) {
               resultList.add(searchX + j);
            }
            break;
         }
      }
      if(resultList.isEmpty()) System.out.println(result);
      else {
         for (Integer integer : resultList) {
            System.out.print(integer + " ");
         }
      }
   }
   public static int sum(int x , int length){
      return length * x + length * (length - 1) / 2;
   }
}
