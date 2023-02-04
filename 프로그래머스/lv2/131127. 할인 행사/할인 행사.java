
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
          int result = 0;
        Map<String, Integer> memo = new HashMap<>();
        int count = 10;
        for (String wish : want) {
            memo.put(wish, 0);
        }

        // 초반 데이터 넣어주기
        for (int i = 0; i < count; i++) {
            String product = discount[i];
            if (memo.containsKey(product)) {
                memo.put(product, memo.get(product) + 1);
            }
        }
        //System.out.println(memo);
        if(isOk(want,number,memo)) result++;
        // 하나씩 늘리면서 검사
        for (int i = count; i < discount.length; i++) {

            String previous = discount[i - count];
            String curProduct = discount[i];
            // 이전 것 있으면 1 빼기
            if (memo.containsKey(previous)) {
                memo.put(previous, memo.get(previous) - 1);
            }
            // 현재 거 1 추가
            if (memo.containsKey(curProduct)) {
                memo.put(curProduct, memo.get(curProduct) + 1);
            }
            //System.out.println(memo);
            // 검사
            if(isOk(want,number,memo)) result++;
        }


        return result;
    }
    public static boolean isOk(String[] want, int[] number, Map<String, Integer> memo) {
        if (memo == null) return false;
        for (int i = 0; i < want.length; i++) {
            if(memo.get(want[i]) < number[i]) return false;
        }
        return true;
    }
}