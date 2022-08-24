class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        // lottos 의 0 의 개수 구하기

        int  zero_count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_count++;
            }
        }
        // lottos 와 win_nums 의 각 숫자를 비교하여 같은 숫자의 수 세기
        int same_count = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    same_count++;
                }
            }
        }
        int min = same_count;
        int max = same_count + zero_count;
        int rateMin = rating(min);
        int rateMax = rating(max);
        int[] answer = new int[2];
        answer[1] = rateMin;
        answer[0] = rateMax;

        return answer;
    }
    static int rating(int num){
        switch (num){
            case 0 , 1:
                return 6;
            case 2 :
                return 5;
            case 3 :
                return 4;
            case 4 :
                return 3;
            case 5 :
                return 2;
            case 6 :
                return 1;
            default:
                return 0;
        }
    }
}