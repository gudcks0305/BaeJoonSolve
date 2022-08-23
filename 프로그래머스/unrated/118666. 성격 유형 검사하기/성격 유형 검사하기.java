import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] survey, int[] choices) {
         Map<String ,Integer> point = new HashMap<>();
        point.put("A", 0);
        point.put("N", 0);
        point.put("J", 0);
        point.put("M", 0);
        point.put("C", 0);
        point.put("F", 0);
        point.put("R", 0);
        point.put("T", 0);
        for(int i=0; i<survey.length;i++){
            if(choices[i] == 4) continue;
            char[] arr = survey[i].toCharArray();
            // 값 박아 넣기

            switch (choices[i]) {
                case 1 -> point.put(String.valueOf(arr[0]), point.getOrDefault(String.valueOf(arr[0]), 0) + 3);
                case 2 -> point.put(String.valueOf(arr[0]), point.getOrDefault(String.valueOf(arr[0]), 0) + 2);
                case 3 -> point.put(String.valueOf(arr[0]), point.getOrDefault(String.valueOf(arr[0]), 0) + 1);
                case 5 -> point.put(String.valueOf(arr[1]), point.getOrDefault(String.valueOf(arr[1]), 0) + 1);
                case 6 -> point.put(String.valueOf(arr[1]), point.getOrDefault(String.valueOf(arr[1]), 0) + 2);
                case 7 -> point.put(String.valueOf(arr[1]), point.getOrDefault(String.valueOf(arr[1]), 0) + 3);
            }

        }
        System.out.println(point);
        String answer = "";
        // 지표 정렬
        if (point.get("R") >= point.get("T")) {
            answer += "R";
        } else {
            answer += "T";
        }
        if(point.get("C") >= point.get("F")){
            answer += "C";
        }else{
            answer += "F";
        }
        if(point.get("J") >= point.get("M")){
            answer += "J";
        }else{
            answer += "M";
        }
        if(point.get("A") >= point.get("N")){
            answer += "A";
        }else{
            answer += "N";
        }

        return answer;
    }
}