package algorithm.Programmers.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        boolean[] check = new boolean[n + 1];
        return BFS(graph, check, 1);
    }

    public int BFS(List<List<Integer>> graph, boolean[] check, int node){
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        check[node] = true;
        int L = 0;
        int[] nodeLevel = new int[check.length];
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int currentV = queue.poll();
                List<Integer> E = graph.get(currentV);
                for (int nv : E){
                    if (!check[nv]){
                        check[nv] = true;
                        queue.offer(nv);
                    }
                }
                nodeLevel[currentV] = L;
                max = L;
            }
            L++;
        }
        for (int a : nodeLevel){
            if (max == a){
                cnt++;
            }
        }
        return cnt;
    }
}
