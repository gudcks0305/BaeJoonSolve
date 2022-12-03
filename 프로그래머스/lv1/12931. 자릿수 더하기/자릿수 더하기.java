import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        String hi = String.valueOf(n);
        for(int i = 0; i < hi.length(); i++){
            sum += Integer.parseInt(String.valueOf(hi.charAt(i)));
        }

        return sum;
    }
}