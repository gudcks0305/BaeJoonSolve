import java.util.*;
class Solution {
    public  int solution(String begin, String target, String[] words) {
        // word에 target 있는지 확인하기
       if(!Arrays.asList(words).contains(target)) return 0;
       
        ArrayList<Integer> results = new ArrayList<>();

        dfs(begin, target, words,  results,0);
        return results.stream().min(Integer::compareTo).get();

    }
    public  void dfs(String begin, String target, String[] words , ArrayList<Integer> results , int count){
        if(begin.equals(target)){
            results.add(count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int cnt = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if(cnt == 1){
                String[] newWords = new String[words.length - 1];
                int index = 0;
                for (int j = 0; j < words.length; j++) {
                    if(i != j){
                        newWords[index++] = words[j];
                    }
                }
                dfs(words[i], target, newWords, results, count + 1);
            }
        }
    }
}