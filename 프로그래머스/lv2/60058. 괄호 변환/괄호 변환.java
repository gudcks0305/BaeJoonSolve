import java.util.Arrays;
import java.util.Stack;
class Solution {
    // p 를 균형잡힌 문자열로 분리 하기 u v 로 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    // u 가 올바른 문자열이라면 v를 다시 u1 v1 으로 나누어 같은 행위
    // u 가 올바른 문자열이 아니라면 빈 문자열에 ( 를 붙힌다.
    // 문자열에 대해 다시 1단계 부터 u v 로 나누어 실행
    // 그 후에 ) 를 붙힌다.
    // u의 첫번째와 마지막 문자를 제거한 후 나머지문자열의 괄호 방향을 뒤집어서 붙힌다.
    // return
   public static String solution(String p) {
        if (p == null || p.length() == 0) return "";
        if (isCorrectStrings(p)) return p;
        StringBuilder sb = new StringBuilder();
        String[] uv = balancedStrings(p);
        System.out.println(Arrays.toString(uv));
        if (isCorrectStrings(uv[0])) {
            sb.append(uv[0]);
            sb.append(solution(uv[1]));
        } else {
            sb.append("(");
            sb.append(solution(uv[1]));
            sb.append(")");
            uv[0] = reverseAndRemoveFirstLast(uv[0]);
            sb.append(uv[0]);
        }
        return sb.toString();
    }

    public static String[] balancedStrings(String p) {
        // 좌측 개수 오른쪽 개수 같을 때 까지 세고 index 찾기
        int left = 0;
        int right = 0;
        int dividIndex = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else right++;
            if (left != 0 && left == right) {
                dividIndex = i;
                break;
            }
        }
        return new String[]{p.substring(0, dividIndex + 1), p.substring(dividIndex + 1)};
    }

    public static boolean isCorrectStrings(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') stack.push(u.charAt(i));
            else {
                if(stack.isEmpty() || stack.peek() == ')' ){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static String reverseAndRemoveFirstLast(String u) {
        StringBuilder sb = new StringBuilder();
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }
}