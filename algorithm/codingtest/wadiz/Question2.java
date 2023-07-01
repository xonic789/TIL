package wadiz;

import java.util.*;

public class Question2 {
    public List<String> solution(String[] code) {
        List<String> answer = new ArrayList<>();
        int block = 0;
        int dotCount = -1;
        List<Map<Character, String>> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++){
            list.add(new HashMap<>());
        }
        for (int i = 0; i < code.length; i++){
            String cmd = code[i];
            int nowDotCount = getDotCount(cmd);
            if (cmd.contains("print")) {
                dotCount = nowDotCount;
                char key = cmd.split(" ")[1].charAt(0);
                Map<Character, String> map = list.get(dotCount);
                if (map.get(key) != null) {
                    answer.add(map.get(key));
                } else {
                    boolean check = false;
                    for (int j = dotCount; j >= 0; j--) {
                        Map<Character, String> tmp = list.get(j);
                        if (tmp.get(key) != null) {
                            answer.add(tmp.get(key));
                            check = true;
                            break;
                        }
                    }
                    if (!check) answer.add("error");
                }
            }else {
                if (dotCount == nowDotCount){
                    dotCount = nowDotCount;
                    Map<Character, String> cmds = list.get(dotCount);
                    String[] split = cmd.split("=");
                    StringBuilder sb = new StringBuilder();
                    for (char a : cmd.toCharArray()){
                        if ('.' != a){
                            sb.append(a);
                        }
                    }
                    cmds.put(split[0].charAt(split[0].length()-1),sb.toString());
                    // 크다면 블록이 사라지는 지점이다.
                    // 블록이 사라지고 새 블록이 생기진 않는다.
                }else if (dotCount > nowDotCount){
                    dotCount = nowDotCount;
                    Map<Character, String> cmds = list.get(dotCount);
                    String[] split = cmd.split("=");
                    StringBuilder sb = new StringBuilder();
                    for (char a : cmd.toCharArray()){
                        if ('.' != a){
                            sb.append(a);
                        }
                    }
                    cmds.put(split[0].charAt(split[0].length()-1),sb.toString());

                }else {
                    dotCount = nowDotCount;
                    Map<Character, String> cmds = list.get(dotCount);
                    String[] split = cmd.split("=");
                    StringBuilder sb = new StringBuilder();
                    for (char a : cmd.toCharArray()){
                        if ('.' != a){
                            sb.append(a);
                        }
                    }
                    cmds.put(split[0].charAt(split[0].length()-1),sb.toString());
                }
            }
            // 현재 . 개수가 이전 . 개수와 같으면 같은 블록이다.

        }

        return answer;
    }

    public int getDotCount(String a){
        int cnt = 0;
        for (char ch : a.toCharArray()){
            if (ch == '.') cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        String[] code = {"a=3",
        "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"};
        System.out.println(new Question2().solution(code));
    }
}
