import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine() , " ");
            String a = st.nextToken();
            String b = st.nextToken();
            map.put(a,b);
        }
        while (m-- > 0) {
            String s = br.readLine();
            bw.write(map.getOrDefault(s, s) + "\n");
        }
        bw.flush();



    }














}