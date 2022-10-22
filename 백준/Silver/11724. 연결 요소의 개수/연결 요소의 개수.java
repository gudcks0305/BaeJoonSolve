
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ArrayList<Integer>> arrayListMap = new HashMap<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0]; // 1 ~ N
        int M = arr[1];

        for(int i = 1; i <= N; i++) {
            arrayListMap.put(i,new ArrayList<>());
        }

        while(M-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            arrayListMap.get(u).add(v);
            arrayListMap.get(v).add(u);
        }
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;
        Queue<Integer> search = new LinkedList<>();
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            search.add(i);
            while (!search.isEmpty()) {
                int cur = search.poll();
                int size = arrayListMap.get(cur).size();
                for (int j = 0; j < size; j++) {
                    int nextNode = arrayListMap.get(cur).get(j);
                    if (!visited[nextNode]) search.add(nextNode);
                    visited[nextNode] = true;
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
