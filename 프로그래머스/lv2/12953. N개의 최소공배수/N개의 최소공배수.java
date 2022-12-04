class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1 ; i < arr.length; i++){
            int gcd = GCD(answer , arr[i]);
            answer = (answer * arr[i]) / gcd; 
        }
        return answer;
    }
    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a % b);
    }
}