import java.util.*;
class Solution {
    public  int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        // 초기 사전
        makeDictionary(dictionary);
        // 초기 값 설정
       // result.add(dictionary.get(String.valueOf(msg.charAt(0))));
        for (int i = 0; i < msg.length(); i++) {
            // 가져온 값 사전에 있으면 계속 있는지 탐색 하고 없으면 그때 마지막 번째에 넣기
            String temp = String.valueOf(msg.charAt(i));
            int j = i;
            // check Dictionary
            while (dictionary.containsKey(temp)) {
                j++;
                if (j >= msg.length()) {
                    break;
                }
                temp += msg.charAt(j);
            }
            //System.out.println(temp);
            // 사전에 없으면 넣기
            if (!dictionary.containsKey(temp)) {
                String s= temp.substring(0, temp.length()-1);
                System.out.println("s : " + s);
                result.add(dictionary.get(s));
                dictionary.put(temp, dictionary.size() + 1);
            }else {
                System.out.println("temp : " + temp);
                result.add(dictionary.get(temp));
            }

            i = j - 1;

        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    public  void makeDictionary(Map<String, Integer> dictionary){
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }
    }
}