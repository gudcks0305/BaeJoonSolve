import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken() + st.nextToken();
        String b = st.nextToken() + st.nextToken();
        Long result = Long.parseLong(a) + Long.parseLong(b);
        System.out.println(result);



    }


}