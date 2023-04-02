
import java.util.*;
class Solution {
    static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        recursionString(numbers , "" , visited);
        String s_maxVal = "";
        for (int i = 0 ; i < numbers.length() ; i++) {
            s_maxVal += "9";
        }
        int maxVal = Integer.parseInt(s_maxVal);

        // 에라토스테네스의 체
        int S[] = new int[maxVal + 1];
        for (int i = 2 ; i < S.length ; i++) {
            S[i] = i;
        }
        for (int i = 2 ; i < Math.sqrt(S.length) ; i++) {
            if (S[i] == 0) {
                continue;
            }
            for (int j = i + i ; j < S.length ; j = i + j) {
                S[j] = 0;
            }
        }

        // HashSet에 저장된 값을 체에 걸러 값이 0이 아니면 answer++
        for (int x : set) {
            if (S[x] != 0) {
                answer++;
            }
        }
        System.out.println(set);
        return answer;
    }
    public void recursionString(String numbers , String store ,boolean[] visited){
        if(store.length() != 0){
            set.add(Integer.parseInt(store));
        }
        if(store.length() == numbers.length()) return;
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            recursionString(numbers , store + numbers.charAt(i) , visited);
            visited[i] = false;
        }
        
    }
    public boolean sosu(int num){
        if(num <= 2) return false;
        int root = (int) Math.sqrt(num);
        for(int i = 2; i <root; i++){
            if(num % i == 0) return false;
        }
        System.out.println(num);
        return true;
    }
}