package algorithm.codingtest.programmers;

import java.util.*;
public class Question1 {
    public List<Boolean> solution(String[] infos, String[] actions) {
        List<Boolean> answer = new ArrayList<>();
        int n = actions.length;
        boolean loginCheck = false;
        List<String> cart = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String[] action = actions[i].split(" ");
            String command = action[0];
            if (command.equals("ADD")){
                if (loginCheck) {
                    answer.add(true);
                    cart.add(action[1]);
                }else answer.add(false);
            }else if (command.equals("LOGIN")){
                if (!loginCheck){
                    for (int j = 0; j < infos.length; j++){
                        String[] info = infos[j].split(" ");
                        String id = info[0];
                        String pw = info[1];
                        if (id.equals(action[1])){
                            if (pw.equals(action[2])){
                                loginCheck = true;
                                answer.add(true);
                                break;
                            }
                        }
                    }
                    if (!loginCheck) answer.add(false);
                }else answer.add(false);
            }else {
                // ORDER
                if (cart.size() != 0){
                    cart = new ArrayList<>();
                    answer.add(true);
                }else answer.add(false);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] infos = {"kim password", "lee abc"};
        String[] actions = {
                "ADD 30",
                "LOGIN kim abc",
                "LOGIN lee password",
                "LOGIN kim password",
                "LOGIN kim password",
                "LOGIN lee abc",
                "ADD 30",
                "ORDER",
                "ORDER",
                "ADD 40",
                "ADD 50"
        };
        System.out.println(new Question1().solution(infos, actions));
    }
}
