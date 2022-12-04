class Solution {
    public int[] solution(int n, int m) {
        int min = GCD(n , m);
        int max = (m * n) / min;
        
        return new int[]{min, max};
    }
    public static int GCD(int num1 , int num2){
        if (num2 == 0) return num1;
        return GCD(num2 , num1 % num2);
    }
}