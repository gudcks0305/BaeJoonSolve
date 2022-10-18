import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length;i++){
            String strArr = br.readLine();
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(strArr.charAt(j)));
            }
        }
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            for (int j = 0 ; j < arr.length; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    result.add(dfs(arr , visited , i , j));
                }
            }
        }
        System.out.println(result.size());
        while (!result.isEmpty()){
            System.out.println(result.poll());
        }

    }
    public static int dfs(int[][] arr , boolean[][] visited , int x , int y){
        if(x < 0 || x >= arr.length || y < 0 || y >= arr.length) return 0;
        if(visited[x][y] || arr[x][y] == 0) return 0;
        visited[x][y] =true;
        int result = 1;
        result += dfs(arr , visited , x-1 , y);
        result += dfs(arr , visited , x+1 ,y);
        result += dfs(arr , visited , x , y-1);
        result += dfs(arr , visited, x , y+1);

        return result;


    }
}
