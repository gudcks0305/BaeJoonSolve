import java.util.*;
class Solution {
    public int[] solution(String s) {
         String[] splitStr = s.split("},");
        for(int i = 0; i < splitStr.length; i++){
            splitStr[i] = splitStr[i].replace("{","");
            splitStr[i] = splitStr[i].replace("}","");
           
          
        }
        System.out.println();
        Arrays.sort(splitStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else {
                    return o1.compareTo(o2);
                }

            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for(String x : splitStr){
            // 7. 한 문자열마다 ,를 기준으로 split하여 새로운 문자열 배열을 만든다.
            String[] temp = x.split(",");
            // 8. 새로만든 문자열 배열에는 정수값만 존재하며 이를 탐색한다.
            for(int i = 0 ; i < temp.length;i++){
                // 9. 각 문자열 값을 정수로 바꾼다.
                int n = Integer.parseInt(temp[i]);
                // 10. 튜플에 들어있는 값이 아니라면 추가해준다.
                if(!result.contains(n))
                    result.add(n);
            }
        }

        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}