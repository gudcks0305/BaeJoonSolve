import java.util.Arrays;
class Solution {
    public int solution(int sticker[]) {
       if (sticker.length == 0) return -1;
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        // 0 번째 부터 선택 하는 경우
        int[] dp1 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            /*if(i == sticker.length - 1) {
                dp1[i] = dp1[i-1];
                continue;
            }*/
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }


        // 1번째부터 선택 하는 경우
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[dp1.length - 2], dp2[dp2.length - 1]);
    }

}