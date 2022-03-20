package algorithm.programmers;

import java.util.*;

public class 신고결과받기 {

    public List<Integer> solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();
        // 신고 당한 횟수를 기록
        Map<String, Integer> resultMap = new HashMap<>();
        // 유저가 누구를 신고했는지
        Map<String, Set<String>> userReportMap = new LinkedHashMap<>();
        for (String id : id_list) {
            resultMap.put(id, 0);
            userReportMap.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] s = r.split(" ");
            String user = s[0];
            String target = s[1];
            // 유저가 신고한 유저 리스트에 추가
            resultMap.put(target, userReportMap.get(user).contains(target) ? resultMap.get(target) : resultMap.get(target) + 1);
            userReportMap.get(user).add(target);
        }

        for (String id : id_list) {
            Set<String> list = userReportMap.get(id);
            int cnt = 0;
            for (String target : list) {
                if (resultMap.get(target) >= 2) {
                    cnt++;
                }
            }
            answer.add(cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(new 신고결과받기().solution(id_list, report, k));
    }
}
