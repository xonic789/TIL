package algorithm.programmers.dfs;

import java.util.*;

public class 여행경로 {

    boolean[] check;
    List<String> answer = new ArrayList<>();


    public String[] solution(String[][] tickets){
        int n = tickets.length;
        int cnt = 0;
        check = new boolean[n];
        DFS(tickets,"ICN", "ICN", cnt);
        answer.sort((o1, o2) -> o1.compareTo(o2));

        return answer.get(0).split(" ");
    }

    public void DFS(String[][] tickets, String airport, String airports, int cnt){
        if (cnt == tickets.length){
            answer.add(airports);
            return;
        }

        for (int i = 0; i < tickets.length; i++){
            if (!check[i] && airport.equals(tickets[i][0])){
                check[i] = true;
                DFS(tickets, tickets[i][1], airports + " " + tickets[i][1], cnt + 1);
                check[i] = false;
            }
        }

    }

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] tickets = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{ "CCC", "ICN"}};

        System.out.println(new 여행경로().solution(tickets));
    }
}
