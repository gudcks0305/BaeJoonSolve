
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        // 10 <= p <= 50
        // 0 <= N <= p
        // List 내림차순 정렬 정의
        if(n <= 0) {
            System.out.println(1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        if(score <= list.get(n-1) && n == p) {
            System.out.println(-1);
            return;
        }
        if(score > list.get(n-1)) {
           list.remove(n-1);
        }
        list.add(score);
        Collections.sort(list, Collections.reverseOrder());
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == score) {
                System.out.println(rank);
                break;
            }
            rank++;
        }
    }

}