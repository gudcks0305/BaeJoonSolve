import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static ArrayList<Integer> button = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 힙 자료구조
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.size() == 0) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll());
            } else {
                pq.add(num);
            }
        }

    }



    // 먼저 가장 첫자리 비교 그리고 다음자리 비교 하는 형식으로 가장 큰 수 넣기


}
