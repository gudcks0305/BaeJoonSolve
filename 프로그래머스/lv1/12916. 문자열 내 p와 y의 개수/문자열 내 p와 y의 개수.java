class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int pNum = 0;
        int yNum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'P') pNum++;
            else if(s.charAt(i) == 'Y') yNum++;
        }
        return pNum == yNum;
    }
}