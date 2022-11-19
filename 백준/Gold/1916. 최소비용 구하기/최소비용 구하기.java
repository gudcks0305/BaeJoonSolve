
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // 첫째줄 도시 개수
        // 둘째 줄 버스의 개수
        // 세쨋줄 부터 버스 정보 // 버스 출발 도시 번호 , 도착지 번호 // 버스 비용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정점의 개수  1 <= N <= 1000
        int M = Integer.parseInt(br.readLine()); // 간선의 개수  1 <= M <= 100,000

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0 ; i < N + 1 ; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            int[] ints = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = ints[0];
            int dest = ints[1];
            int cost = ints[2];
            // start to dest by cost
            graph.get(start).add(new Node(dest , cost));
        }
        int[] ints = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = ints[0];
        int dest = ints[1];

        boolean[] visited = new boolean[N + 1]; // 도시 방문 체킹
        int[] dist = new int[N + 1];  // 매번 거리 정보를 갱신할 배열 선언

        for (int i = 0; i < N + 1 ; i++){
            // 초기 값을 최대값으로 초기화 , 최소 거리를 구하는 것이기 때문에
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        dijkstra(visited ,graph , dist);
        //System.out.println(Arrays.toString(dist));
        System.out.println(dist[dest]);
    }
    public static  void dijkstra(boolean[] visited , ArrayList<ArrayList<Node>> graph , int[] dist ){
        int N = visited.length; // 정점의 수
        // 0번째는 안씀
        for (int i = 1; i < N; i++){
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j = 1 ; j < N; j++){
                // 방문하지 않은 노드 중 최소 값의 노드를 찾는다.
                if(!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }
            visited[nodeIdx] = true; // 선택된 노드 방문 처리

            // 선택 된 노드로 최소 비용 갱신
            renew(nodeIdx , graph , dist);
        }
    }
    public static void  renew(int nodeIdx , ArrayList<ArrayList<Node>> graph , int[] dist){
        for (int j = 0; j < graph.get(nodeIdx).size(); j++){
            Node node =  graph.get(nodeIdx).get(j);
            // 인접 노드로 가는 비용이 저장된 최소 비용보다
            // 현재 노드로 가는 최소 비용과 인접 노드로 가는 값과을 더해 비교 하여 작은 값으로 갱신
            if(dist[node.index] > dist[nodeIdx] + node.cost){
                dist[node.index] = dist[nodeIdx] + node.cost;
            }
        }
    }
    public static class Node {
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
