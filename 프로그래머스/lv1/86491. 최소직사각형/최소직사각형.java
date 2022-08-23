import java.util.*;
class Solution {
    static int solution(int [][]arr){
        // arr 에서 max값
        int max1 = Arrays.stream(arr).max(
                (a,b) ->{
                    return a[0] - b[0];
                }
        ).get()[0];
        int max2 = Arrays.stream(arr).max(
                (a, b) -> {
                    return a[1] - b[1];
                }
        ).get()[1];
        int max = Math.max(max1, max2);
        int x = max;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            int minVal = Math.min(arr[i][0], arr[i][1]);
            if(y <= minVal){
                y = minVal;
            }
        }
        return x * y;
    }
}