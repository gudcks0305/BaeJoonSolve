import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWord = new HashSet<>();
        int cnt = 1;
        usedWord.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
                int preSize = usedWord.size();
                usedWord.add(words[i]);


                if (preSize == usedWord.size()) {
                    System.out.println("I:" + i + " pre : " + preSize + "curSize : " + usedWord.size());
                    return new int[]{cnt % n + 1, cnt / n + 1};
                }
            } else {
                return new int[]{cnt % n + 1, cnt / n + 1};
            }
            cnt++;


        }


        return new int[]{0, 0};
    }
}