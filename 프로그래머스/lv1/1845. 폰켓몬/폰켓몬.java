import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> distinct = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int pickNums = nums.length / 2;
        return Math.min(distinct.size(), pickNums);
    }
}