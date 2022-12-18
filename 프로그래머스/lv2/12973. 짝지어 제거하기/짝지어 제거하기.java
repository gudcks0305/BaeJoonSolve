import java.util.Stack;
class Solution
{
   public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            Character bef = stack.peek();
            if (bef == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }
        return stack.isEmpty() ? 1 : 0;
    }
}