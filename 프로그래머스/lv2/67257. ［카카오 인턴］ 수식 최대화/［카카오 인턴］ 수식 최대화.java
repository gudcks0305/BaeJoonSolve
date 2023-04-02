import java.util.*;

class Solution {
    static char[] tok = {'+','-','*'};
    static List<String> comb = new ArrayList<>();
    static long MAX = 0;
    public long solution(String expression) {
        long answer = 0;
        List<Character> tokens = new ArrayList<>();
        List<Long> nums = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(expression.substring(start, i)));
                tokens.add(c);
                start = i + 1;
            }
        }
        nums.add(Long.parseLong(expression.substring(start)));
        tokens.add(' '); // 마지막 숫자에 대한 연산자 추가
        System.out.println(tokens);
        System.out.println(nums);
        combination(tok,"", new boolean[3]);
        System.out.println(comb);
        for(int i = 0 ; i < comb.size(); i++){
            cal(comb.get(i) , new ArrayList<>(nums) , new ArrayList<>(tokens));
        }
        answer = MAX;
        return answer;
    }
    public void cal(String tokcom , List<Long> nums , List<Character> tokens){
        for(int i = 0; i < tokcom.length(); i++){
            char c = tokcom.charAt(i);
            for(int j = 0; j < tokens.size(); j++){
                if(c == tokens.get(j)){
                    if(c == '+'){
                        nums.set(j, nums.get(j) + nums.get(j+1));
                        nums.remove(j+1);
                        tokens.remove(j);
                        j--;
                    }else if(c == '*'){
                        nums.set(j, nums.get(j) * nums.get(j+1));
                        nums.remove(j+1);
                        tokens.remove(j);
                        j--;
                    }else{
                        nums.set(j, nums.get(j) - nums.get(j+1));
                        nums.remove(j+1);
                        tokens.remove(j);
                        j--;
                    }
                }
            }
        }        
        System.out.println(nums);
        
        MAX = Math.max(MAX , Math.abs(nums.get(0)));
    }
    public void combination(char[] tok , String store , boolean[] visited){
        if(store.length() == tok.length){
            comb.add(store);
        }
        for(int i = 0; i < tok.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            combination(tok , store+tok[i] ,visited);
            visited[i] = false;
        }
    }
}
