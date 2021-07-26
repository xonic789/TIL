package algorithm.inflearn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */
public class 경로탐색_인접리스트 {
    static int answer = 0, n,m;
    static List<List<Integer>> graph;
    static boolean[] check;

    static void DFS(int v){
        check[v] = true;
        if (v == n) answer++;
        for (int e : graph.get(v)){
            if (!check[e]){
                DFS(e);
                check[e] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }

        for (List<Integer> list : graph){
            System.out.println(list);
        }
        DFS(1);
        System.out.println(answer);
    }

}
