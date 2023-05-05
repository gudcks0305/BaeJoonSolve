import java.util.*;
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }
}