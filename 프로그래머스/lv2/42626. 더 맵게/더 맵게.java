import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public static int solution(int[] scoville, int K) {
      PriorityQueue<Integer> foods = Arrays.stream(scoville).boxed().collect(PriorityQueue::new, PriorityQueue::add, PriorityQueue::addAll);
      int count = 0;
      while (!foods.isEmpty() && foods.peek() < K){
         int firstFood = foods.poll();
         if(foods.isEmpty()) return -1;
         int secondFood = foods.poll();
         foods.add(mix(firstFood , secondFood));
         count++;
      }
      return count;
   }
   public static int mix (int lowScoville , int secondScoville){
      return lowScoville + 2 * secondScoville;
   }
}