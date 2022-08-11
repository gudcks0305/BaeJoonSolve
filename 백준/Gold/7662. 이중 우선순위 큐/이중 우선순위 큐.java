import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> map;
        while (n-- >0){
            int m = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                String[] s = br.readLine().split(" ");
                String command = s[0];
                int number = Integer.parseInt(s[1]);
                solve(map, command, number);
            }
            if(map.size() == 0) {
                System.out.println("EMPTY");
            }else {
                System.out.println(map.lastEntry().getKey() + " " + map.firstEntry().getKey());
            }
        }
    }

    private static void solve(TreeMap<Integer, Integer> map, String command, int number) {
        if (command.equals("I")){
            //System.out.println("INSERT : " + number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        } else if (command.equals("D")){
            if(map.size() == 0){
                return;
            }
            if(number == 1) {
              //  System.out.println("DELETE : " + map.lastEntry().getKey());
                if(map.get(map.lastEntry().getKey()) == 1) {
                    map.remove(map.lastEntry().getKey());
                }else {
                    map.put(map.lastEntry().getKey(), map.get(map.lastEntry().getKey()) - 1);
                }
            }
            else if(number == -1){
               // System.out.println("DELETE : " + map.firstEntry().getKey());
                if(map.get(map.firstEntry().getKey()) == 1) {
                    map.remove(map.firstEntry().getKey());
                }else {
                    map.put(map.firstEntry().getKey(), map.get(map.firstEntry().getKey()) - 1);
                }
            }
        }


    }


}
