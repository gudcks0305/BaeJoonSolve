import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        String[] value = br.readLine().split(" ");

        for (int i = N - 1; i >= 0; i--) {
            int num = Integer.parseInt(value[i]);
            // 임시 스택 비어있지 않고 현재 들어오는 값이 임시 스택의 top 보다 크면 스택에 있는걸 다 뺀다.
            while(!tmp.isEmpty() && (num >= tmp.peek())) {
                tmp.pop();
            }
            // 위에서 만약 다 빠졌으면 조건에 만족하는 놈이 없기 때문에  정답 스택에 -1 추가
            // 마지막 value의 경우 항상 -1 이 나오기 때문에 tmp가 비어있으면 -1
            if(tmp.isEmpty()) {
                stack.add(-1);
            }else { // 비어있지 않으면 조건에 만족하는 값을 찾았기때문에 peek 해서 정답으로 가져온다. 
                stack.add(tmp.peek());
            }
            tmp.add(num);
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);

    }
}
