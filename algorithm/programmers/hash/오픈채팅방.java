package algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        int n = record.length;
        Map<String, String> map = new LinkedHashMap<>();


        for (int i = 0; i < n; i++){
            String[] actions = record[i].split(" ");
            String action = actions[0];

            if (action.equals("Enter") || action.equals("Change")){
                map.put(actions[1],actions[2]);
            }else {

            }
        }

        for (int i = 0; i < n; i++){
            String[] actions = record[i].split(" ");
            String action = actions[0];
            String uid = actions[1];
            String nick = map.get(uid);

            if (action.equals("Enter")){
                answer.add(nick+"님이 들어왔습니다.");
            }else if(action.equals("Leave")){
                answer.add(nick+"님이 나갔습니다.");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(new 오픈채팅방().solution(record));
    }
}
