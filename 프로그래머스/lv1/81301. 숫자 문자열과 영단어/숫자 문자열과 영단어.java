class Solution {
    String[] engNums = {"zero" , "one" , "two" , "three" , "four" , 
                        "five" , "six" , "seven" , "eight" , "nine"};
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < engNums.length; i++){
            s = s.replace(engNums[i] , String.valueOf(i));
            
        }
        System.out.print(s);
        answer = Integer.parseInt(s);
        return answer;
    }
}