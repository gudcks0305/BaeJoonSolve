import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String dartResult) {
         List<Integer> results = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            int nums = 0;
            String nums1 = dartResult.charAt(i) + "";
            String nums2 = "";
            nums = Integer.parseInt(nums1);
            if (dartResult.charAt(i+1) == '0') {
                nums2 = dartResult.charAt(i+1) + "";
                nums = Integer.parseInt(nums1 + nums2);
                i++;
            }
            int nMulti = check(dartResult.charAt(i + 1));
            int currentPoint = nums;
            currentPoint = (int) Math.pow(currentPoint, nMulti);
            if (i + 2 < dartResult.length()) {
                if (dartResult.charAt(i + 2) == '#') {
                    currentPoint = - currentPoint;
                    i++;
                } else if (dartResult.charAt(i + 2) == '*') {
                    if(results.size() != 0) results.set(results.size() - 1 , 2 * results.get(results.size() -1));
                    currentPoint *= 2;
                    i++;
                }
            }
            System.out.println("nums : " + nums + " nMulti : " + nMulti + " currentPoint : " + currentPoint);
            i++;
            results.add(currentPoint);
        }
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    public static int check(char c) {
        if (c == 'S') return 1;
        else if (c == 'D') return 2;
        return 3;
    }
}