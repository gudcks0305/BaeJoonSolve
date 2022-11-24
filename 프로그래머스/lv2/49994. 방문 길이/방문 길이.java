class Solution {
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        int answer = 0;
        int x = 5, y = 5;
        for(int i=0; i<dirs.length(); i++) {
            int nx = x, ny = y;
            if(dirs.charAt(i) == 'U') ny++;
            else if(dirs.charAt(i) == 'D') ny--;
            else if(dirs.charAt(i) == 'R') nx++;
            else if(dirs.charAt(i) == 'L') nx--;
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            int dir = 0;
            if(dirs.charAt(i) == 'U') dir = 0;
            else if(dirs.charAt(i) == 'D') dir = 3;
            else if(dirs.charAt(i) == 'R') dir = 2;
            else if(dirs.charAt(i) == 'L') dir = 1;
            if(!visited[x][y][dir]) {
                System.out.println("x : " + x + " y : " + y + " dir : " + dir);
                visited[x][y][dir] = true;
                visited[nx][ny][3-dir] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}