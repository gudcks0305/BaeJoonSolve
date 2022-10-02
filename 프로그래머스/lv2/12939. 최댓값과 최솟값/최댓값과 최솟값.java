import java.util.ArrayList;
class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        ArrayList<Integer> resultList = new ArrayList<>();
        for(String num : ss){
            if(num.startsWith("-")){
                resultList.add(-Integer.parseInt(num.substring(1)));
            }else{
                resultList.add(Integer.parseInt(num));
            }
        }
        int max = resultList.stream().mapToInt(i->i).max().getAsInt();
        int min = resultList.stream().mapToInt(i->i).min().getAsInt();
        return min + " " + max;
    }
}