import java.util.*;
class Solution {
    public boolean solution(int x) {
        String values = String.valueOf(x);
        int sum = Arrays.stream(values.split("")).mapToInt(Integer::parseInt).sum();
        return x % sum == 0;
    }
}