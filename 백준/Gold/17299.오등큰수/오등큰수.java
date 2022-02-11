import java.io.*;
import java.util.Stack;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        // 사이즈 변수
        String[] temp = br.readLine().split(" ");
        // 다음 라인 받아서 split 임시로 String 배열에 담았다가
        int[] numbers = new int[size];
        // 크기 비교를 위해 int 배열로 변경
        int[] counts = new int[1000001];
        // 해당 숫자가 몇 번 나왔는지 기록해둘 배열 생성해서
        int[] answer = new int[size];
        // 오등 큰수 저장할 배열

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
            // int를 string으로 변경
            counts[numbers[i]] += 1;
            // 기록 배열에 해당 숫자 1 증가
        }

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        // 처음 인덱스는 그냥 넣고
        for (int i = 1; i < size; i++) {
            // 1부터 끝까지 반복
            if (stack.isEmpty()) {
                // 스택이 비어있는 경우에는
                stack.push(i);
                // 그냥 스택에 인덱스 저장
            }

            while (!stack.isEmpty() && counts[numbers[i]] > counts[numbers[stack.peek()]]) {
                // 스택이 비어있지 않고 숫자가 스택 가장 윗 숫자와 비교해서 큰 경우 반복
                answer[stack.pop()] = numbers[i];
                // stack 하나 비우면서 그 인덱스에 숫자를 넣는다
            }
            stack.push(i);
            // 반복이 끝나면 다음에 비교할 값 stack에 입력

        }

        while (!stack.isEmpty()) {
            // 반복문이 모두 끝난 후에도 stack에 값이 있다면
            answer[stack.pop()] = -1;
            // 빌때까지 해당 인덱스에 -1을 넣는다
        }

        for (int i = 0; i < size; i++) {
            bw.write(String.valueOf(answer[i] + " "));
            // 출력
        }
        bw.write("\n");
        bw.flush();

        bw.close();
        br.close();
    }

}