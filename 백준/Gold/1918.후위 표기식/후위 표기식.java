import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (w >= 'A' && w <= 'Z') {
                sb.append(w);
            }else {
                if(w == '(') stack.push(w);
                else if(w==')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                }else {
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(w) ){
                        sb.append(stack.pop());
                    }
                    stack.push(w);
                }
            }

        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
    public static int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.
    }
}
