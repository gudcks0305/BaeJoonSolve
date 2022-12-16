import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer[]> printer = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            // 중요도 , 처음 순서
            printer.add(new Integer[]{priorities[i], i});
        }
        while (!printer.isEmpty()) {
            Integer[] docs = printer.poll();
            if(isValid(docs , printer)) {
                answer++;
                if(docs[1] == location) return answer;
                continue;
            }
            printer.add(docs);
        }
        return answer;
    }

    private boolean isValid(Integer[] docs ,  Queue<Integer[]> printer) {
        return printer.stream().noneMatch(i -> docs[0] < i[0]);
    }
}