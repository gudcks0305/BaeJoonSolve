import java.util.*;
class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public int solution(String[] board) {
        int[] startingPoint = searchPoint(board , 'R');
        int[] destinyPoint = searchPoint(board , 'G');
        boolean[][][] visited = new boolean[board.length][board[0].length()][4];
        Queue<int[]> que = new LinkedList<>();
        que.add(startingPoint);
        //System.out.println(Arrays.toString(startingPoint));
        //System.out.println(Arrays.toString(destinyPoint));
        while(!que.isEmpty()){
            int[] curPoint = que.poll();
            for(int i = 0; i < 4; i++){
                int[] movePoint = movePoint(i , curPoint , board);
                if(visited[movePoint[0]][movePoint[1]][i]) continue;
                if(board[movePoint[0]].charAt(movePoint[1]) == 'G'){
                    return movePoint[2];
                }
                que.add(movePoint);
                visited[movePoint[0]][movePoint[1]][i] = true;
            }
        }
        return -1;
    }
    public int[] searchPoint(String[] board , char point){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == point) {
                    return new int[]{i , j , 0};
                } 
            }
        }
        return null;
    }
    public int[] movePoint(int direction, int[] curPoint, String[] board) {
    int curY = curPoint[0];
    int curX = curPoint[1];
    int curMove = curPoint[2];
    while (
            curY + dy[direction] >= 0 && curY + dy[direction] < board.length &&
                    curX + dx[direction] >= 0 && curX + dx[direction] < board[0].length() &&
                    board[curY + dy[direction]].charAt(curX + dx[direction]) != 'D'
    ) {
        curY += dy[direction];
        curX += dx[direction];
    }

    return new int[]{curY, curX, curMove + 1};
}
}