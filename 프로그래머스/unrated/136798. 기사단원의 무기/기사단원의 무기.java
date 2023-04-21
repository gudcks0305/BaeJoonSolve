import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            int how = how(i);
            result.add(how > limit ? power : how);
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }
    public int how(int n){
        int cnt = 0;
        for(int i = 1; i * i <= n; i++){
            if(i * i == n) cnt++;
            else if(n % i == 0) cnt +=2;
        }
        return cnt;
    }
}