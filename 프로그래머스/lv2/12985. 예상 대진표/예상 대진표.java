class Solution
{
    public int solution(int n, int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int result = 1;
        while (max % 2 != 0 || max - 1 != min) {
            max = divid(max);
            min = divid(min);
            result++;
        }
        return result;
    }
    public int divid(int num){
        if(num % 2 == 0) return num /2;
        return num / 2 + 1;
    }
}