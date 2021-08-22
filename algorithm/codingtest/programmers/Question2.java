package algorithm.codingtest.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question2 {
    public List<String> solution(String[] grades) {
        Map<String, String> map = new LinkedHashMap<>();


        List<String> collect = Arrays.stream(grades).sorted((obj1, obj2) -> {
            if (getScore(obj1.split(" ")[1]) < getScore(obj2.split(" ")[1])) return -1;
            else if (getScore(obj1.split(" ")[1]) > getScore(obj2.split(" ")[1])) return 1;
            else return 0;
        }).collect(Collectors.toList());
        int n = grades.length;
        for (String content : collect){
            String[] grade = content.split(" ");
            String number = grade[0];
            String score = grade[1];
            String tmp = map.get(number);
            if (tmp == null){
                map.put(number, score);
            }else {
                //
                if (getScore(score) < getScore(tmp)){
                    map.put(number, score);
                }
            }
        }
        List<String> answer = new ArrayList<>(map.size());
        for (Map.Entry<String, String> tmp : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(tmp.getKey()).append(" ").append(tmp.getValue());
        }


        return answer;
    }

    public int getScore(String grade){
        String[] arr = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(grade)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        String[] grades = {"DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"};
        System.out.println(new Question2().solution(grades));
    }
}
