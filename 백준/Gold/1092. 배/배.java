
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] crain = Arrays.stream(br.readLine().split(" ")).sorted().mapToInt(Integer::parseInt).toArray();
        N = Integer.parseInt(br.readLine());
        int[] boxes = Arrays.stream(br.readLine().split(" ")).sorted().mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(crain , boxes));
    }

    public static int solution(int[] crains, int[] boxes) {
        // 제일 무거운 걸 들 수 있는 애가 박스 중 가장 무거운 애를 못 들면 박스를 모두 옮길 수 없다.
        Arrays.sort(crains);
        Arrays.sort(boxes);
        if (crains[crains.length - 1] < boxes[boxes.length - 1]) return -1;
        // 옮긴 박스 처리
        List<Integer> boxList = Arrays.stream(boxes).boxed().sorted().collect(Collectors.toList());
        int time = 0;
        // 박스를 다 옮길 떄 까지 ...
        while (!boxList.isEmpty()){
            for (int crain : crains) {
                if(boxList.isEmpty()) break;
                int index = 0;
                while (index < boxList.size() - 1 ) {
                    if(crain < boxList.get(index)) break;
                    index++;
                }
                if(index != 0 ) index -= 1;
                if (crain >= boxList.get(index)) boxList.remove(index);
            }
            time++;
        }
        return time;
    }
}
