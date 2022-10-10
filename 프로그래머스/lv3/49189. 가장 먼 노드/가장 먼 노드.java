import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
         int answer = 0;
        // 인접 리스트로 변경
        HashMap<Integer,ArrayList<Integer>> arrayLists = new HashMap<>();
        for (int i = 0; i < edge.length; i++) {
            arrayLists.put(edge[i][0],new ArrayList<>());
            arrayLists.put(edge[i][1],new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            arrayLists.get(edge[i][0]).add(edge[i][1]);
            arrayLists.get(edge[i][1]).add(edge[i][0]);
        }
        // 노드별 최단 거리
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        // 방문 여부
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        // 방문할 노드
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int i = 0; i < arrayLists.get(node).size(); i++) {
                int nextNode = arrayLists.get(node).get(i);
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    distance[nextNode] = distance[node] + 1;
                    queue.add(nextNode);
                }
            }
        }
        // 최대 거리
        int max = 0;
        for (int i = 1; i < distance.length; i++) {
            max = Math.max(max,distance[i]);
        }
        // 최대 거리의 노드 개수
        for (int i = 1; i < distance.length; i++) {
            System.out.println(distance[i]);
            if(distance[i] == max){
                answer++;
            }
        }


        return answer;
    }
}