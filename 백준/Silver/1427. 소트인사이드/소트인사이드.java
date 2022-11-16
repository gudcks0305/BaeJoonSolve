
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      String input = br.readLine();
      // 자릿수 char 변경 하고... 사전순 정렬하고 ...
      Character[] inputArr = input.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
      Arrays.sort(inputArr , Collections.reverseOrder());
      System.out.println(Arrays.stream(inputArr).map(String::valueOf).reduce("", String::concat));
   }
}
