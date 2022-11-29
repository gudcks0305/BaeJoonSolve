import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
class Solution {
   // 각 ban_id 마다 벤이 가능한 유저아이디 목록 
    static List<List<String>> bannedId;
    static Set<Set<String>> result;
    static int userCnt, bannedCnt;

    public  int solution(String[] user_id, String[] banned_id) {
        userCnt = user_id.length;
        bannedCnt = banned_id.length;
        bannedId = new ArrayList<>();
        result = new HashSet<>();

        for (String id : banned_id) bannedId.add(getIdList(user_id, id));

        dfs(0, new HashSet<>());

        return result.size();
    }

    static List<String> getIdList(String[] user_id, String id) {
        String pattern = id.replace('*', '.');

        List<String> res = new ArrayList<>();

        for (String next : user_id) {
            if (Pattern.matches(pattern, next)) res.add(next);
        }
        return res;
    }

    static void dfs(int depth, Set<String> tmpSet) {
        if (depth == bannedCnt) {
            result.add(new HashSet<>(tmpSet));
            //System.out.println(tmpSet);
            //System.out.println(tmpSet.hashCode());
            return;
        }
        for (String bannedId : bannedId.get(depth)) {
            if (!tmpSet.contains(bannedId)) {
                tmpSet.add(bannedId);
                dfs(depth + 1, tmpSet);
                tmpSet.remove(bannedId);
            }
        }
    }
}