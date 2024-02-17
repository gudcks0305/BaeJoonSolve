import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static int[][] AB= new int[2][1000];
  private static int point = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // An = Bn-1
    // Bn = An-1 + Bn-1
    int n = Integer.parseInt(br.readLine()) + 1;
    AB[0][0] = 1;
    AB[1][0] = 0;
    AB[0][1] = 0;
    AB[1][1] = 1;
    for (int i = 2; i <= n; i++) {
      AB[0][i] = AB[1][i - 1];
      AB[1][i] = AB[0][i - 1] + AB[1][i - 1];
    }
    System.out.println(AB[0][n-1] + " " + AB[1][n-1]);
  }
  // A         , A 1 B 0
  // B 1       , B 0 A 1
  // BA 2     , B 1 B 1
  // BAB       , B 2 A 1
  // BABBA , B 3 A 2
  // BA B BA BA B  , B 5 A 3
}