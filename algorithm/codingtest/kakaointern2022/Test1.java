package kakaointern2022;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        // 점수지
        int[] scoreMap = {0, 3, 2, 1, 0, 1, 2, 3};
        String[] indicators = {"RT", "CF", "JM", "AN"};
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            String left = String.valueOf(indicators[i].charAt(0));
            String right = String.valueOf(indicators[i].charAt(1));
            resultMap.put(left, 0);
            resultMap.put(right, 0);
        }
        int n = survey.length;
        for (int i = 0; i < n; i++) {
            String left = String.valueOf(survey[i].charAt(0));
            String right = String.valueOf(survey[i].charAt(1));
            int choice = choices[i];
            if (choice > 4) {
                resultMap.put(right, resultMap.get(right) + scoreMap[choice]);
            }
            if (choice < 4) {
                resultMap.put(left, resultMap.get(left) + scoreMap[choice]);
            }
        }
        for (String indicator : indicators) {
            String left = String.valueOf(indicator.charAt(0));
            String right = String.valueOf(indicator.charAt(1));
            Integer a = resultMap.get(left);
            Integer b = resultMap.get(right);
            if (a > b) {
                answer.append(left);
            } else if (a < b) {
                answer.append(right);
            } else {
                answer.append(left);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(new Test1().solution(survey, choices));
    }
}
