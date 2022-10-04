import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        // S 를 만들 수 있는 원소를 K 라고 할 때 1 <= K <= s/n
        // K = s/n
        int answer[] = new int[n];
        int mid = s/n;
        int remain = s%n;
        int sum = s / n * n;
        if(sum == s){
            for(int i = 0; i < n; i++){
                answer[i] = mid;

            }
        }else{
            for(int i = 0; i < n; i++){
                answer[i] = mid;
            }
            for(int i = 0; i < n; i++){
                for(int j = n-1; j >= 0; j--){
                    if(sum == s) break;
                    answer[j] += 1;
                    sum += 1;
                }
            }
        }

        return answer;
    }
}