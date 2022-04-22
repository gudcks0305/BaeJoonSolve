class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];
        String s = "";
        for (int i = 0; i < numbers.length;i++){
            s += numbers[i];
        }
        int result = 0;
        for (int i = 0; i < arr.length;i++){
            arr[i] = i;
            if(!s.contains(String.valueOf(arr[i]))) result += arr[i];
        }
        return result;
    }
}