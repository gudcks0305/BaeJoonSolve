class Solution {
    public String solution(String s) {
        int size = s.length();
        if(size % 2 != 0 ) return String.valueOf(s.charAt(size/2));
        return s.substring(size / 2 -1 , size / 2 + 1);
    }
}