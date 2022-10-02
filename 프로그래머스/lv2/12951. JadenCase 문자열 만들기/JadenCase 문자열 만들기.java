class Solution {
    public String solution(String s) {
        if(s.length() == 0) return s;
        String[] sArr = s.split(" ");
        if(sArr.length == 0) return s;
        String result = "";
        System.out.println(sArr.length);
        for(int i = 0 ; i < sArr.length;i++){
            if(sArr[i].length() == 0) {
                result += " ";
                continue;
            }
            // 소문자 시작이면 첫놈 대문자행 , 나머지 소문자행 
            if(sArr[i].charAt(0) <= 'z'&& 'a'<= sArr[i].charAt(0)){
                sArr[i] = 
                    sArr[i].substring(0,1).toUpperCase() + sArr[i].substring(1).toLowerCase();
            }else { // 소문자로 시작하는게 아니면 전부 첫글자 제외 소문자 행
                sArr[i] = 
                    sArr[i].substring(0,1) + sArr[i].substring(1).toLowerCase();
            }
            if(i == sArr.length -1){
                result += sArr[i];
                break;
            }
            result += sArr[i] + " ";
        }
        if(s.substring(s.length() -1, s.length()).equals(" ")) return result + " ";
        return result;
    }
}