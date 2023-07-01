package kakao2021;

import java.util.ArrayList;
import java.util.List;

public class Question5 {
    // 비트마스킹 또는 DFS
    List<List<Integer>> graph;
    boolean[] check;
    int sheep;
    int wolf;
    int answer;

    public int solution(int[] info, int[][] edges) {
        // sheep 0
        // wolf 1
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
//        check = new boolean[info.length];

        DFS(0, info, 0);
        return sheep;
    }

    // left 0 right 1
    public void DFS(int root, int[] info, int direction){
//        check[root] = true;
        if (info[root] == 0) sheep++;
        else wolf++;
        List<Integer> nodes = graph.get(root);
        if (nodes.size() == 0) {
            wolf--;
        }
        if (direction == 1 )

        for (int node : nodes){
            if (info[node] == 0){
                DFS(node, info, direction);
            }else {
                DFS(node, info, direction);
            }
        }

        // 늑대일 경우

    }

    public static void main(String[] args) {
//        int[] infos = {0,0,1,1,1,0,1,0,1,0,1,1};
//        int[][] edges = {
//                {0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
//        };
        int[] infos = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}
        };
        Question5 question5 = new Question5();
        System.out.println(question5.solution(infos, edges));
    }
}