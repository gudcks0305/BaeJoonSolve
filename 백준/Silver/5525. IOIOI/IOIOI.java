import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int cnt = 0;
        int ioNum = 0;
        for (int i = 2; i < m; i++) {
            if(s[i-2] == 'I' && s[i-1] == 'O' && s[i]== 'I'){
                ioNum++;
                i++;
            }else {
                ioNum = 0;
            }
            if(ioNum >= n) cnt++;
        }
        System.out.println(cnt);
    }

}






