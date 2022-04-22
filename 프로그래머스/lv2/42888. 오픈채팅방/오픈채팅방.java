import java.util.*;
class Solution {
    public String[] solution(String[] record) {
          ArrayList<String> arr = new ArrayList();
		HashMap<String, String> map = new HashMap();
		for (int i = 0; i < record.length; i++) {
			String[] command = record[i].split(" ");

			if (command[0].equals("Enter")) {
				arr.add(command[1] + "님이 들어왔습니다.");
				map.put(command[1], command[2]);
			} else if (command[0].equals("Change")) {
				map.put(command[1], command[2]);
			} else {
				arr.add(command[1] + "님이 나갔습니다.");
			}
		}
		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			int idx = arr.get(i).indexOf("님");
			String id = arr.get(i).substring(0, idx);
			String[] temp = arr.get(i).split(" ");
			answer[i] = map.get(id) + "님이 " + temp[1];
		}
        return answer;
    
    }
    public static class User{
        String id;
        String nickname;

        public User(String id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
    public static class Message{
        User user;
        String leaveOrEnter;

        public Message(User user, String leaveOrEnter) {
            this.user = user;
            this.leaveOrEnter = leaveOrEnter;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getLeaveOrEnter() {
            return leaveOrEnter;
        }

        public void setLeaveOrEnter(String leaveOrEnter) {
            this.leaveOrEnter = leaveOrEnter;
        }
    }
}