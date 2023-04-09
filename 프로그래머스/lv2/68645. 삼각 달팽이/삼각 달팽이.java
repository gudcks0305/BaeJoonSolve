import java.util.*;
class Solution {
   static int[] dy = {1,0,-1};
    static int[] dx = {0,1,-1};
    public int[] solution(int n) {
        int[] answer = {};
        int[][] maps = new int[n][n];
        int max = max(n);
        Queue<int[]> que = new LinkedList<>();
        // y , x , dir ,cnt
        que.add(new int[]{0,0,0,1});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            maps[cur[0]][cur[1]] = cur[3];
            if(cur[3] == max) break;
            int[] next = nextPoint(maps,cur);
            que.add(next);
        }
        return result(maps);
    }
    private void print(int[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    private int[] result(int[][] map){
        int[] result = new int[max(map.length)];
        int idx = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != 0){
                    result[idx++] = map[i][j];
                }
            }
        }
        return result;
    }
    private int[] nextPoint(int[][] map, int[] cur){
        int dir = cur[2];
        int curY = cur[0];
        int curX = cur[1];
        if(dir == 0 && (curY == map.length - 1|| map[curY + dy[dir]][curX+dx[dir]] != 0 )){
            dir = 1;
        }
        else if(dir == 1 && (curX == map[0].length - 1|| map[curY + dy[dir]][curX+dx[dir]] != 0 )){
            dir = 2;
        }else if(dir == 2 && map[curY + dy[dir]][curX+dx[dir]] != 0){
            dir = 0;
        }
        return new int[]{curY + dy[dir] , curX+dx[dir] , dir , cur[3] + 1};
    }
    private int max(int n){
        int result = 0;
        for(int i = 1; i <= n; i++){
            result += i;
        }
        return result;
    }
}