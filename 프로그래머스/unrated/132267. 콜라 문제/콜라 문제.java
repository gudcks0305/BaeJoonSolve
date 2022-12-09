class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        while (n >= a) {
            int used = n / a * a;
            int gived = (n / a) * b;
            result += gived;
            n = n - used + gived;
            System.out.println(n);

        }
        return result;
    }
}