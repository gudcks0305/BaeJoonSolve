import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String pocketmon = br.readLine();
            String number = Integer.toString(i+1);
            map.put(pocketmon, number);
            map.put(number, pocketmon);
        }


        for(int i=0; i<m; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.print(sb);




    }







}








