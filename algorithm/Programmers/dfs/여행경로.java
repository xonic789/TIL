package algorithm.Programmers.dfs;

import java.util.*;

public class 여행경로 {

    boolean[] check;
    List<List<String>> answer = new ArrayList<>();
    public List<String> solution(String[][] tickets){
        int n = tickets.length;
        // graph 만들기
        for (int i = 0; i < n; i++){
            if (tickets[i][0].equals("ICN")){
                check = new boolean[n];
                List<String> list = new ArrayList<>();
                list.add("ICN");
                DFS(list, tickets,i, tickets[i][1]);
                boolean flag = false;
                for (boolean boo : check){
                    if(!boo) {
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    answer.add(list);
                }

            }
        }
        answer.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++){
                // o1 String 과 o2 의 String 을 비교하여 o1 기준으로
                // o1.charAt(i) - o2.charAt(i) 를 수행하여 양수라면
                // 그대로 둔다.
                // 음수라면 바꾼다.
                if (o1.get(i).compareTo(o2.get(i)) > 0){
                    return 1;
                }else if (o1.get(i).compareTo(o2.get(i)) < 0){
                    return -1;
                }
            }
            return 0;
        });

        return answer.get(0);
    }

    public void DFS(List<String> list, String[][] tickets, int ticket, String airport){
        check[ticket] = true;
        list.add(airport);
        for (int i = 0; i < tickets.length; i++){
            if (!check[i] && airport.equals(tickets[i][0])){
                DFS(list, tickets, i, tickets[i][1]);
                break;
            }
        }
    }


    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] tickets = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{ "CCC", "ICN"}};

        System.out.println(new 여행경로().solution(tickets));
    }
}
