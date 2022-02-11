import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String word = br.readLine();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if(w >='A' && w <= 'Z'){
                    stack.push((double) arr[(w - 65)]);
            }else {
                double d1 = stack.pop(), d2 = stack.pop();
                double d3 = 0;
                switch (w) {
                    case '+' :
                        d3 = d2 + d1;
                        break;
                    case '-' :
                        d3 = d2 - d1;
                        break;
                    case '*' :
                        d3 = d2 * d1;
                        break;
                    case '/' :
                        d3 = d2 / d1;
                        break;

                }
                stack.push(d3);

            }

        }
        System.out.printf("%.2f" , stack.pop());

    }
}
