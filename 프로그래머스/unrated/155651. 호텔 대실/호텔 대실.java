import java.util.*;
class Solution {
    static int CLEAN_TIME = 10;
    public  int solution(String[][] book_time) {
        int minRoom = 0;
        int[][] time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            time[i][0] = stringTimeToInt(book_time[i][0]);
            time[i][1] = stringTimeToInt(book_time[i][1]);
        }
        Arrays.sort(time, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(time));
        int[] room = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            int start = time[i][0];
            int end = time[i][1];
            for (int j = 0; j < room.length; j++) {
                if (room[j] <= start) {
                    room[j] = end + CLEAN_TIME;
                    break;
                }
            }
        }
        for (int i = 0; i < room.length; i++) {
            if (room[i] != 0) {
                minRoom++;
            }
        }
        return minRoom;
    }
    public static int stringTimeToInt(String timeString){
        if (timeString == null || timeString.isEmpty()) {
            return 0;
        }
        String[] time = timeString.split(":");
        // time to int
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

}