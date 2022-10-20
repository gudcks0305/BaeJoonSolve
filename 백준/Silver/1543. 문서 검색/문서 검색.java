import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      String docs = br.readLine();
      String words = br.readLine();
      int cnt = 0;
      for (int i = 0 ; i < docs.length(); i++){
         // words 크기만큼 docs 나눈다음 비교

         if(i + words.length() > docs.length()){
           break;
         }
         String divided = docs.substring(i , i + words.length());

         // 아니면 i++
         if(words.equals(divided)){
            i += words.length() -1;
            cnt++;
         }
      }
      System.out.println(cnt);
   }
}
