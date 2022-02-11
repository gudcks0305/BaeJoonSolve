import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '(') {
                stack.push('(');
            } else if (word.charAt(i) == ')') {
                stack.pop();
                if (word.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
                    count += stack.size(); // 현재 stack의 사이즈만큼 더해 줌.
                } else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
                    count++; // 단순히 1을 더해 줌.
                }
            }
        }
        bw.write(count + "\n");
        bw.close();
    }
}
