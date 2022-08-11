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
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        while (deque.size() != 1){
            deque.removeFirst();
            deque.add(deque.removeFirst());
        }
        System.out.println(deque.getFirst());
    }




}
