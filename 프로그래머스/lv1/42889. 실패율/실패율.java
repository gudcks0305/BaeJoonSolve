import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
         // 실패율 클리어 못한 사람 수 / 스테이지에 도닳한 플레이어의 수
        // 스테이지 개수 N , 게임을 이용하는 플레이이어의 현재 스테이지 stages
        // 스테이지를 통과한 사람 수를 담을 배열...
        // 스테이지를 통과 못한 사람을 담을 배열 ...
        Map<Integer, Integer[]> stageMaps = new HashMap<>();
        // Integer[0] -> 도전한 사용자 수  : 클리어못한 사람 + 클리어한 사람
        // Integer[1] -> 현재 클리어 못한 사용자수 -> stages[i] == stageMaps's key
        for (int i = 1; i <= N; i++) {
            stageMaps.put(i, new Integer[]{0, 0});
        }
        for (int i = 0; i < stages.length; i++) {
            Integer curStage = stages[i];
            if (curStage <= N) {
                Integer[] curNums = stageMaps.get(curStage);
                curNums[1]++;
            }
            int min = Math.min(curStage, N);
            for (int j = 1; j <= min; j++) {
                Integer[] lowStages = stageMaps.get(j);
                lowStages[0]++;
            }
        }
        for (Integer[] cur : stageMaps.values()) {
            System.out.println(Arrays.toString(cur));
        }
        // 실패율을 담을 배열
        Map<Integer, Double> failRate = new HashMap<>();
        for (Integer key : stageMaps.keySet()) {
            Integer[] cur = stageMaps.get(key);
            if (cur[0] == 0) {
                failRate.put(key, 0.0);
            } else {
                failRate.put(key, (double) cur[1] / cur[0]);
            }
        }
        // 실패율을 기준으로 내림차순 정렬
        List<Integer> keys = new ArrayList<>(failRate.keySet());
        keys.sort((o1, o2) -> (failRate.get(o2).compareTo(failRate.get(o1))));
        return keys.stream().mapToInt(i -> i).toArray();
    }
}