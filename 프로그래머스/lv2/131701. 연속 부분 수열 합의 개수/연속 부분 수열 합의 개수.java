import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> resultSet = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0 ; j < elements.length; j++){
                int trackers = tracking(j , j , 1 , i , elements);
                resultSet.add(trackers);
            }
        }
        return resultSet.size();
    }
    public int tracking(int startIdx,int index , int depth ,int howLong , int[] elements){
        if(index > elements.length - 1) {
            index = index - elements.length;
        }
        int result = elements[index];
        
        if(depth == howLong) {
            return result;
        }
        result += tracking(startIdx , index + 1 , depth + 1 , howLong , elements);
        return result;
        
        
    }
}