import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if(visited[i]) continue;
            Queue<Integer> networkQue = new LinkedList<>();
            networkQue.add(i);
            while (!networkQue.isEmpty()){
                int computer = networkQue.poll();
                for(int j = 0; j < computers.length;j++){
                    if(!visited[j] && computers[computer][j] == 1){
                        networkQue.add(j);
                        visited[j] = true;
                    }
                }
            }
            answer++;

        }
        return answer;
    }
}