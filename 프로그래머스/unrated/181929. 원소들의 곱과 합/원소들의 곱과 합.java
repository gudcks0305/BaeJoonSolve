class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int temp2 = 1;
        for(int i = 0 ; i < num_list.length; i++){
            answer += num_list[i];
            temp2 *= num_list[i];
        }
        return answer * answer > temp2 ? 1: 0; 
    }
}