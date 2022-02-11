import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //int N = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int last = 0;
        String[] com = {"push_back", "push_front","pop_front","pop_back","size","empty","front","back"};
        int var;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push_back" :
                    command = st.nextToken();
                    var = Integer.parseInt(command);
                    deque.offer(var);
                    break;
                case "push_front" :
                    command = st.nextToken();
                    var = Integer.parseInt(command);
                    deque.addFirst(var);

                    break;
                case "pop_front" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(deque.poll()).append("\n");
                    }
                    break;
                case "pop_back" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else {

                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if(deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else{

                        sb.append(deque.element()).append("\n");
                    }

                    break;
                case "back" :
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else {

                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;


            }

        }
        System.out.println(sb);
    }
}
