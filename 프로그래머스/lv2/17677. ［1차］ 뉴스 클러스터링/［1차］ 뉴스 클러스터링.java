
import java.util.*;
import java.util.regex.Pattern;
class Solution {
     public  int solution(String str1, String str2) {
        int answer = 0;
        // str1 과 str2 를 2개씩 짜른 각각 List<String> 만들기
        // str1 과 str2 교집합 구하기
        // str1 과 str2 합집합 구하기 -> set ?
        List<String> str1List = dividString(str1);
        List<String> str2List = dividString(str2);
        Collections.sort(str1List);
        Collections.sort(str2List);
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        for(String s : str1List) {
            if(str2List.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가
                intersection.add(s);
            }
            union.add(s);
        }
        // 교집합에서 제외된 것 뺀 나머지 합집합에 추가
        union.addAll(str2List);
        // str1list 을  1 2 의 교집합으로 만들기
        double a = intersection.size();
        double b = union.size();

        double jakard = 0;

        if(union.size() == 0)
            jakard = 1;	// 공집합일 경우 1
        else
            jakard = (double) intersection.size() / (double) union.size();

        return (int) (jakard * 65536);
    }


    public  List<String> dividString(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i - 1, i + 1).toUpperCase();
            if (checkEng(temp)) result.add(temp);
        }
        return result;
    }

    public  boolean checkEng(String s) {
        String pattern = "^[A-Za-z]*$";
        return Pattern.matches(pattern, s);
    }
}