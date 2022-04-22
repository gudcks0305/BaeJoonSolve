class Solution {
    public int solution(int n) {
        
        String convertThree = "";
         while (n > 0){
            convertThree += n % 3;
            n /= 3;
        }
        int result = 0;
        for (int i = 0; i < convertThree.length(); i++) {
            result += Math.pow(3 , convertThree.length()-i-1) * Integer.parseInt(String.valueOf(convertThree.charAt(i)));
        }
        return result;
    }
}