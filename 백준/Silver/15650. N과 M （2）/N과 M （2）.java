
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<int[]> results = new ArrayList<>();
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] comes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = comes[0];
        M = comes[1];
        visited = new boolean[N];
        // arr 에 1부터 N까지 숫자를 넣는다.
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        // 1부터 N까지 숫자 중에서 M개를 뽑는다.
        combination(arr , new int[M] , 0 , N , M , 1);
        for (int[] result : results) {
            System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }

    }

    // combination
    public static void combination(int[] arr, int[] result, int depth, int n, int r, int target) {
        if (depth == r) {
            results.add(result.clone());
            return;
        }
        for (int i = target; i <= n; i++) {
            if(!visited[i-1]){
                visited[i-1] = true;
                result[depth] = arr[i-1];
                combination(arr, result, depth + 1, n, r, i+1);
                visited[i-1] = false;
            }
        }
    }
}
