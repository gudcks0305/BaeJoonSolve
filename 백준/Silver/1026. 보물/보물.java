import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            alist.add(Integer.parseInt(s[i]));
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            blist.add(Integer.parseInt(s[i]));
        }
        alist.sort(Comparator.naturalOrder());
        // 큰 수부터 정렬
        blist.sort(Comparator.reverseOrder());
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += alist.get(i) * blist.get(i);
        }
        System.out.println(sum);

    }


}








