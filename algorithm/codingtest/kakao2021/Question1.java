package algorithm.codingtest.kakao2021;

import java.util.*;

public class Question1 {

    public List<Integer> solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> reportCount = new LinkedHashMap<>();
        Map<String, Set<String>> toReport = new LinkedHashMap<>();
        // 유저를 모두 담는다.
        for (String id : id_list){
            reportCount.put(id, 0);
            toReport.put(id, new HashSet<>());
        }
        for (String repo : report){
            String[] r = repo.split(" ");
            // 자신의 아이디
            String id = r[0];

            // 신고 한 아이디
            String reportId = r[1];

            Set<String> toRepo = toReport.get(id);
            int beforeSize = toRepo.size();
            toRepo.add(reportId);
            int afterSize = toRepo.size();
            if (beforeSize != afterSize) reportCount.put(reportId, reportCount.get(reportId) + 1);
        }

        for (String id : id_list){
            int cnt = 0;
            Set<String> reportIds = toReport.get(id);
            for (String ids : reportIds){
                int rc = reportCount.get(ids);
                if (rc >= k) cnt++;
            }
            answer.add(cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        System.out.println(new Question1().solution(id_list, report, 2));
    }
}
