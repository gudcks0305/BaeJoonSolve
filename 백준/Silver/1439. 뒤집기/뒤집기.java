
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s= br.readLine();
      System.out.println(solution(s));
   }
   public static int solution(String s){
        int zero = 0;
        int one = 0;
        if(s.charAt(0)=='0'){
             zero++;
        }else{
             one++;
        }
        for (int i = 0; i < s.length()-1; i++) {
             if(s.charAt(i)!=s.charAt(i+1)){
                if(s.charAt(i+1)=='0'){
                 zero++;
                }else{
                 one++;
                }
             }
        }
        return Math.min(zero,one);
   }
}
