import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String , Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
        }
        map.keySet().removeIf(s -> map.get(s) != 2);
        sb.append(map.size()).append("\n");
        mapSortByKeySet(map);
        System.out.println(sb);

    }
    static void mapSortByKeySet(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        List<String> list = new ArrayList<>(keys);
        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append("\n");
        }
    }



}





