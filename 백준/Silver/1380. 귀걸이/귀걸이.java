
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0 입력시 종료
        int count = 1;
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            // 입력받은 문자열을 공백을 기준으로 나누어 배열에 저장
            String[] inputArray = new String[Integer.parseInt(input)];
            for (int i = 0; i < inputArray.length; i++) {
                inputArray[i] = br.readLine();
            }
            Map<Integer, String> earingMap = new HashMap<>();
            for (int i = 0; i < 2 * inputArray.length - 1; i++) {
                String[] earing = br.readLine().split(" ");
                if (earingMap.containsKey(Integer.parseInt(earing[0]))) {
                    if (!earingMap.get(Integer.parseInt(earing[0])).equals(earing[1])) {
                        earingMap.remove(Integer.parseInt(earing[0]));
                    }
                } else {
                    earingMap.put(Integer.parseInt(earing[0]), earing[1]);
                }
            }
            int finalCount = count;
            earingMap.keySet().forEach(key -> {
                System.out.println(finalCount + " " + inputArray[key - 1]);
            });
            count++;
        }


    }


}