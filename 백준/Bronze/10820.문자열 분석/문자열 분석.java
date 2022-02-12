import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean hi = true;
        int[] num = new int[4];
        String word = "";
        while ((word = br.readLine()) != null){

            if (word.length() == 0) {
                hi = false;
            }
            for (int i = 0; i < num.length; i++) {
                num[i] = 0;
            }
            for (int j = 0; j < word.length(); j++) {
                char k = word.charAt(j);
                if( k  >= 'a' && k <= 'z') num[0]++;
                else if (k  >= 'A' && k <= 'Z') num[1]++;
                else if(k>= '0' && k<='9') num[2]++;
                else if(k==' ') num[3]++;
            }
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i]+" ");
            }
            System.out.println();

        }


    }


}