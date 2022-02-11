import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> arr = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //int N = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int j = start + 1; j <= value; j++) {
                    arr.push(j);
                    sb.append('+').append('\n');
                }
                start = value;
            } else if (arr.elementAt(arr.size()-1) != value) {
                System.out.println("NO");
                return;
            }
            arr.pop();
            sb.append('-').append("\n");
        }
        for (int value : arr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
