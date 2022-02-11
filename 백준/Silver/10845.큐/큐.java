import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //int N = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int last = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push")) {
                command = st.nextToken();
                int var = Integer.parseInt(command);
                last = var;
                queue.offer(var);
            } else if (command.equals("pop")) {
                if(!queue.isEmpty()) sb.append(queue.poll()).append("\n");
                else sb.append(-1).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                if(queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("front")) {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(queue.element()).append("\n");
                }
            }else if (command.equals("back")) {
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(last).append("\n");
                }
            }

        }
        System.out.println(sb);
    }

}
