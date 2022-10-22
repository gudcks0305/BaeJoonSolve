
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int cur = arr[0];
      int broPoint = arr[1];
      int[] map  = new int[100001];
      int result = bfs(cur , map , broPoint);
      System.out.println(result);
   }
   private static int  bfs(int node , int[] visited , int K)
   {
      Queue<Integer> queue = new LinkedList<Integer>();

      queue.add(node);
      int index = node;
      int n = 0;
      visited[index] = 1;
      while (!queue.isEmpty())
      {
         n = queue.remove();

         if (n == K)
         {
            return visited[n]-1;
         }

         if (n-1>=0 && visited[n-1] == 0)
         {
            visited[n-1] = visited[n]+1;
            queue.add(n-1);
         }
         if (n+1 <= 100000 && visited[n+1] == 0)
         {
            visited[n+1] = visited[n]+1;
            queue.add(n+1);
         }
         if (2*n <= 100000 && visited[2*n] == 0)
         {
            visited[2*n] = visited[n] + 1;
            queue.add(2*n);
         }
      }
      return -1;
   }

}
