class Solution {
    static int count = 0;

    public  int solution(int[] numbers, int target) {
        dp(numbers, target, 0, 0);
        return count;
    }

    public static void dp(int[] numbers, int target, int cur, int index) {
        if (cur == target && index == numbers.length) {
            count++;
            return;
        }
        if(index == numbers.length) return;

        dp(numbers, target, cur - numbers[index], index + 1);
        dp(numbers, target, cur + numbers[index], index + 1);

    }
}