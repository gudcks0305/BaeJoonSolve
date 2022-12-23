import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] gems) {
         Set<String> set = Arrays.stream(gems).collect(Collectors.toSet());
        // 범위 찾기
        int left = 0;
        int right = 0;

        // 최소 값 최대 값을 저장할
        int start = 0;
        int end = 0;
        int distance  = Integer.MAX_VALUE;

        // 보석 배열을 순회 하면서 Map에 추가 하기
        Map<String,Integer> gemsMap = new HashMap<>();
        while (true) {
            // 현재 챙긴 보석 종류 수가 보석 종류 수와 같으면
            if(set.size() == gemsMap.size()){
                // 오른쪽에 해당 되는 애 1개 추가
                //right++;
                //gemsMap.put(gems[right] , gemsMap.get(gems[right]) + 1);
                // 좌측 애 빼기
                gemsMap.put(gems[left] , gemsMap.get(gems[left]) -1);
                // 제일 좌측 애 0 이면 map 종류에서 빼주기 보석 0 개 가지고 잇으면 가지고 있는게 아님
                if(gemsMap.get(gems[left]) == 0) gemsMap.remove(gems[left]);
                left++;

            } else if (right >= gems.length) {
                break;
            } else{
                // 같지 않으면 넣어주기
                gemsMap.put(gems[right] , gemsMap.getOrDefault(gems[right] , 0) + 1 );
                right++;
            }


            // 보석을 챙기던지

            //현재 챙긴 수가  보석 종류수와 같으면 거리 계산 하기
            if(gemsMap.size() == set.size()) {
                if(distance > right - left) {
                    start = left+1;
                    end = right;
                    distance = right - left;
                }
            }
        }
        return new int[]{start,end};
    }
}