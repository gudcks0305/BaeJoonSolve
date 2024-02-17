class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
    int cards1sIndex = 0;
    int cards2sIndex = 0;
    int goalIndex = 0;
    for(String goalStr : goal){
      if(cards1sIndex < cards1.length && cards1[cards1sIndex].equals(goalStr)){
        cards1sIndex++;
      }else if(cards2sIndex < cards2.length && cards2[cards2sIndex].equals(goalStr)){
        cards2sIndex++;
      }else{
        answer = "No";
        break;
      }
    }
    return answer;
    }
}