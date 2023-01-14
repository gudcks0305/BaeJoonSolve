
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        // 어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
        //
        //미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[10];
        // 숫자 개수 세기
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - '0']++;
        }
        // 숫자의 합 구하기
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i * arr[i];
        }
        // 30의 배수가 아니면 -1 출력

        if (sum % 3 != 0 || arr[0] == 0) {
            System.out.println(-1);
            return;
        }
        // 30의 배수이면 내림차순으로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }
        System.out.println(sb);
    }


}

