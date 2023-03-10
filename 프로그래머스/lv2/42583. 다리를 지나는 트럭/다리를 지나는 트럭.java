import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
          Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int currentTotalWeight = 0;
        for (int truck_weight : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck_weight);
                    currentTotalWeight += truck_weight;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    currentTotalWeight -= queue.poll();
                } else {
                    if (isWeightOK(currentTotalWeight, truck_weight, weight)) {
                        queue.add(truck_weight);
                        currentTotalWeight += truck_weight;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }

    public static boolean isWeightOK(int currentTotalWeight, int truck_weight, int maxWeight) {
        return currentTotalWeight + truck_weight <= maxWeight;
    }
}