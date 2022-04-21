import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static int n, m , h;
    static int[] arr;

    // 주어진 숫자와 가장 가까우면서 주어진 수 x - arr[i] >= 0  인 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        while (true){
            if(m == 0) break;
            int max = 0;
            for (int i = 0; i < n; i++){
                if(m - arr[i] >= 0){
                    max = Math.max(max, arr[i]);
                }
            }
            // 여기서 가장 큰 값 나온 걸 주어진수 나눠서 목만큼 곱해서 뺴고 목만큼 cnt 추가 !
            int num = m / max ;
            m = m - num * max;
            cnt += num;
        }
        System.out.print(cnt);

    }

}
