import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            String s = line.substring(i, i + 1);
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));
        if(keys.size() == 1){
            System.out.println(keys.get(0));
        }
        else if (Objects.equals(map.get(keys.get(0)), map.get(keys.get(1)))) {
            System.out.println("?");
        } else {
            System.out.println(keys.get(0));
        }







    }



}
