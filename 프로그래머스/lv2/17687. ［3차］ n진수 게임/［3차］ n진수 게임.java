class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m * t + 1; i++) {
            String s = Integer.toString(i, n);
            sb.append(s);
        }
        // My turn is p , p + m , p + 2m ...
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(sb.charAt(p - 1 + i * m));
        }

        return result.toString().toUpperCase();
    }
}