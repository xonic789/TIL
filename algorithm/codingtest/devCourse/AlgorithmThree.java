package algorithm.codingtest.devCourse;

import java.util.ArrayList;
import java.util.List;
/**
 * 프로그래머스 데브코스 백엔드 과정 3번
 */
public class AlgorithmThree {
    private boolean[] check;
    private int count;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 끊어진 노드 2개를 담을 배열이며
        // 해당 노드의 연결된 노드들의 갯수를 담을 배열
        int[] arr = {0,0};
        // while문을 wires length 만큼 돌리기 위해 변수 cnt를 둔다.
        int cnt = 0;
        int wiresN = wires.length;
        while(cnt < wiresN){
            // 하나 끊어 본다.
            // 하나 끊은 그래프를 담기 위한 List
            List<List<Integer>> graph = new ArrayList<>();
            // 빈 인접리스트 생성.
            for (int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < wiresN; i++){
                // 그래프를 만들 때 cnt와 i가 같을 때 제외해야 할 wires을
                // arr에 담는다. 그래프에 담지 않으려 continue 시킨다.
                if (i == cnt){
                    arr[0] = wires[i][0];
                    arr[1] = wires[i][1];
                    continue;
                }
                int x = wires[i][0];
                int y = wires[i][1];
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            // 끊은 노드 기준으로 DFS 수행.
            for (int j = 0; j < 2; j++){
                check = new boolean[n + 1];
                DFS(graph,arr[j]);
                arr[j] = count;
                count = 0;
            }
            // 절대값으로 min 연산한다.
            int abs = Math.abs(arr[0]-arr[1]);
            if (answer > abs){
                answer = abs;
            }
            cnt++;
        }
        return answer;
    }

    public void DFS(List<List<Integer>> graph, int v) {
        if (check[v]) return;
        check[v] = true;
        count++;
        for (int nodes : graph.get(v)){
            if (!check[nodes]){
                DFS(graph,nodes);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(new AlgorithmThree().solution(n,wires));
    }

}
