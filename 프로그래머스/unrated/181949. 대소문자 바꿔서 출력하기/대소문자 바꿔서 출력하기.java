import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        // 결과를 저장할 StringBuilder를 생성합니다.
        StringBuilder sb = new StringBuilder();

        // 입력받은 문자열의 각 문자를 확인합니다.
        for (char c : a.toCharArray()) {
            // 해당 문자가 소문자인 경우
            if(Character.isLowerCase(c)) {
                // 대문자로 변환하여 StringBuilder에 추가합니다.
                sb.append(Character.toUpperCase(c));
            }
            // 해당 문자가 대문자인 경우
            else if(Character.isUpperCase(c)) {
                // 소문자로 변환하여 StringBuilder에 추가합니다.
                sb.append(Character.toLowerCase(c));
            }
        }
        
        // 변환한 문자열을 출력합니다.
        System.out.println(sb.toString());
    }
}
