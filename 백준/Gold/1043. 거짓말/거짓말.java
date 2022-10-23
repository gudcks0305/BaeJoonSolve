
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 최초 진실 아는 놈 받을 리스트
        ArrayList<Integer> truth = new ArrayList<>();

        int answer;

        int N = sc.nextInt();
        int M = sc.nextInt();
        answer = M;
        // 파티 담기 
        ArrayList<Integer>[] party = new ArrayList[M];

        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int people = sc.nextInt();
            truth.add(people);
        }

        for (int i = 0; i < M; i++) {
            // 파티 수 
            cnt = sc.nextInt();
            party[i] = new ArrayList<>();

            for (int j = 0; j < cnt; j++) {
                // 
                int people = sc.nextInt();
                party[i].add(people);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] partyCheck = new int[M];
        int[] peopleCheck = new int[N + 1];

        for (int i = 0; i < truth.size(); i++) {
            // 진실을 아는 애들 큐에 넣어주기 
            q.add(truth.get(i));
            // 진실 안다고 체킹 하기 
            peopleCheck[truth.get(i)] = 1;

        }

        while (!q.isEmpty()) {
            // 큐에서 하나 빼기 
            int now = q.poll();
            // 파티 하나씩 체크 
            for (int i = 0; i < M; i++) {
                // 체크된 파티면 검사할 필요가 없음
                if (partyCheck[i] == 1)
                    continue;
                // 파티가 지금 뽑은 인원 포함 안하면 노필요 
                if (!party[i].contains(now))
                    continue;
                // 진실을 말해야 하는 파티에 참석한 친구들 모두 큐에 넣기 
                for (int j = 0; j < party[i].size(); j++) {
                    int next = party[i].get(j);
                    // 그중에서 체크된 친구들 빼고 
                    if (peopleCheck[next] == 1)
                        continue;
                    peopleCheck[next] = 1;
                    q.add(next);
                }
                // for 온전히 하나가 끝나면 파티 체킹 
                partyCheck[i] = 1;
                answer--;
            }
        }


        System.out.println(answer);
    }
}
