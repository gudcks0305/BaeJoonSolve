import java.util.Stack;
class Solution {
    boolean solution(String s) {
      Stack<Character> stack = new Stack<>();
      for (char word : s.toCharArray()){
         if(word == '(' ) stack.add(word);
         else {
            if(stack.isEmpty()) return false;
            stack.pop();
         }
      }
      return stack.isEmpty();
    }
}