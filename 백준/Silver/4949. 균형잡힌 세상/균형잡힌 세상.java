
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = br.readLine();
                if (input.equals(".")) break;
                closed(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void closed(String args) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < args.length(); i++) {
            if (args.charAt(i) == '{') stack.add(args.charAt(i));
            else if (args.charAt(i) == '[') stack.add(args.charAt(i));
            else if (args.charAt(i) == '(') stack.add(args.charAt(i));
            else if (args.charAt(i) == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    System.out.println("no");
                    return;
                }
                stack.pop();
            }
            else if (args.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println("no");
                    return;
                }
                stack.pop();
            }
            else if (args.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println("no");
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) System.out.println("yes");
        else System.out.println("no");
    }
}
