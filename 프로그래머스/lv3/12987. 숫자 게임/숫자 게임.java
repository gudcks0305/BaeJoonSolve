import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] A, int[] B) {
       // A 길이 == B 길이
        // A[i] == B[i] noting
        // A[i] < B[i] result += 1
        // A 순서 고정 B[i] 순서는 가변으로 할 수 있을 때  result 의 크키가 최대 인 것은 ?
        // 각 배열의 원소는 한 번 씩 밖에 사용 못한다.
        // A[i] 보다 큰 수 중 가장 B[i] 에서 가장 작은 수 를 구하자
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int idx = 0;
        for(int i = 0 ; i < A.length;i ++){
            int numberA = A[i];
            int numberB = 0;
            for(int j = idx ; j < B.length; j++){
                if(idx >= B.length){
                    break;
                }
                if(B[j] > numberA){
                    answer += 1;
                    idx = j + 1;
                    break;
                }
            }

        }

        return answer;
    }
}