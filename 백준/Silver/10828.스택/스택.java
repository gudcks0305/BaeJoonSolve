import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws IOException {
        ArrayList<Integer> stack = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //int N = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.add(value);

            } else if (command.equals("pop")) {
                if (stack.size() != 0) {
                    sb.append(stack.get(stack.size()-1)).append("\n");
                    stack.remove(stack.size() - 1);
                }else sb.append(-1).append("\n");
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (command.equals("empty")) {
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("top")) {
                if (stack.size() != 0) {
                    sb.append(stack.get(stack.size() - 1)).append("\n");
                }
                if(stack.isEmpty()) sb.append(-1).append("\n");
            }

        }
        System.out.println(sb);

    }



}